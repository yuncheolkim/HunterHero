package com.cloverfew.repository.mybatis;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PlayerDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Player player = new Player();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = player.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<byte[]> data = player.data;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> account = player.account;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = player.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Player extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<byte[]> data = column("`data`", JDBCType.VARCHAR);

        public final SqlColumn<String> account = column("account", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public Player() {
            super("player");
        }
    }
}