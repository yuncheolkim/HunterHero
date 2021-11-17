package com.cloverfew.repository;

import com.cloverfew.repository.mybatis.User;
import com.cloverfew.repository.mybatis.UserDynamicSqlSupport;
import com.cloverfew.repository.mybatis.UserMapper;
import game.anno.Repos;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * @author Yunzhe.Jin
 * 2021/8/21 12:43
 */
@Repos(config = "mybatis-user.xml")
public class UserRepository extends BaseRepository<UserMapper> {

    public long insert(User c) {
        UserMapper mapper = mapper();
        mapper.insertSelective(c);
        return c.getId();
    }

    public List<User> all() {
        UserMapper mapper = mapper();
        return mapper.selectMany(SqlBuilder.select(UserMapper.selectList).from(UserDynamicSqlSupport.user)
                .build().render(RenderingStrategies.MYBATIS3));
    }

    public Optional<User> login(String account, String password) {
        UserMapper mapper = mapper();
        return mapper.selectOne(SqlBuilder.select(UserMapper.selectList).from(UserDynamicSqlSupport.user)
                .where()
                .and(UserDynamicSqlSupport.account, SqlBuilder.isEqualTo(account))
                .and(UserDynamicSqlSupport.password, SqlBuilder.isEqualTo(password))
                .build().render(RenderingStrategies.MYBATIS3));
    }

    public Optional<User> findByAccount(String account) {
        UserMapper mapper = mapper();
        return mapper.selectOne(SqlBuilder.select(UserMapper.selectList).from(UserDynamicSqlSupport.user)
                .where()
                .and(UserDynamicSqlSupport.account, SqlBuilder.isEqualTo(account))
                .build().render(RenderingStrategies.MYBATIS3));
    }

    public void delete(Integer id) {
        CompletableFuture.runAsync(() -> {
            UserMapper mapper = mapper();
            mapper.deleteByPrimaryKey(id);
        });
    }
}
