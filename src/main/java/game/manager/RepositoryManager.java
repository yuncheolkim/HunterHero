package game.manager;

import com.cloverfew.repository.BaseRepository;
import game.anno.Repos;
import game.base.AbsLifecycle;
import game.base.Logs;
import game.utils.ClassUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
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


    @Override
    public void start() {

        // mybatis

        Map<String, SqlSessionFactory> factoryMap = new HashMap<>();
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

                    Repos annotation = load.getAnnotation(Repos.class);
                    SqlSessionFactory factory = factoryMap.get(annotation.config());

                    if (factory == null) {
                        try {
                            Logs.C.info("加载mybatis config: {}", annotation.config());
                            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(annotation.config()));
                            factoryMap.put(annotation.config(), factory);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    BaseRepository value = load.getDeclaredConstructor().newInstance();
                    value.setFactory(factory);
                    repoMap.put(load, value);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void stop() {

    }

    public static <T> T getRepo(Class<T> cla) {
        return (T) repoMap.get(cla);
    }

}
