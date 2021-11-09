package game.manager;

import com.cloverfew.repository.BaseRepository;
import com.google.common.reflect.ClassPath;
import game.base.AbsLifecycle;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yunzhe.Jin
 * 2021/11/9 20:37
 */
public class RepositoryManager extends AbsLifecycle {
    public static final String SCAN_PACKAGE = "com.cloverfew";

    private static Map<Class<?>, BaseRepository<?>> repoMap = new HashMap<>();

    String resource = "mybatis-config.xml";

    SqlSessionFactory factory;


    public void start() {

        // mybatis
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        factory = new SqlSessionFactoryBuilder().build(inputStream);

        try {
            ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream().filter(classInfo -> {
                return classInfo.getPackageName().startsWith(SCAN_PACKAGE);
            }).filter(classInfo -> !classInfo.getName().equals(BaseRepository.class.getName()) && BaseRepository.class.isAssignableFrom(classInfo.load())).forEach(classInfo -> {
                Class<? extends BaseRepository> load = (Class<? extends BaseRepository>) classInfo.load();
                try {
                    System.out.println("put:" + load.getName());
                    repoMap.put(load, load.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (BaseRepository<?> value : repoMap.values()) {
            factory.getConfiguration().addMapper(value.getType());
        }

    }

    @Override
    public void stop() {

    }

    public SqlSessionFactory getFactory() {
        return factory;
    }


    public static <T> T getRepo(Class<T> cla) {
        return (T) repoMap.get(cla);
    }

}
