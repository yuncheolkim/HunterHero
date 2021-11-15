package game.manager;

import com.cloverfew.repository.BaseRepository;
import game.base.AbsLifecycle;
import game.base.Logs;
import game.utils.ClassUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
            Set<Class<?>> search = ClassUtils.search(SCAN_PACKAGE, null);
            for (Class<?> aClass : search) {
                Logs.C.info("Scan:{}", aClass.getName());
            }

            search.stream().filter(classInfo -> {
                return classInfo.getPackageName().startsWith(SCAN_PACKAGE);
            }).filter(classInfo -> !classInfo.getName().equals(BaseRepository.class.getName()) && BaseRepository.class.isAssignableFrom(classInfo)).forEach(classInfo -> {
                Class<? extends BaseRepository> load = (Class<? extends BaseRepository>) classInfo;
                try {
                    Logs.C.info("加载repo: {}", load.getName());
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
