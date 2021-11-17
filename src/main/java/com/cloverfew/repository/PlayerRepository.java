package com.cloverfew.repository;

import com.cloverfew.repository.mybatis.Player;
import com.cloverfew.repository.mybatis.PlayerDynamicSqlSupport;
import com.cloverfew.repository.mybatis.PlayerMapper;
import game.anno.Repos;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;

import java.util.Optional;

/**
 * @author Yunzhe.Jin
 * 2021/8/21 12:43
 */
@Repos(config = "mybatis-user.xml")
public class PlayerRepository extends BaseRepository<PlayerMapper> {

    public long insert(Player c) {
        PlayerMapper mapper = mapper();
        mapper.insertSelective(c);
        return c.getId();
    }

    public Optional<Player> findByAccount(String account) {
        PlayerMapper mapper = mapper();
        return mapper.selectOne(SqlBuilder.select(PlayerMapper.selectList).from(PlayerDynamicSqlSupport.player)
                .where()
                .and(PlayerDynamicSqlSupport.account, SqlBuilder.isEqualTo(account))
                .build().render(RenderingStrategies.MYBATIS3));
    }
}
