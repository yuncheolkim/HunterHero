package com.cloverfew.repository.mybatis;

import java.io.Serializable;
import javax.annotation.Generated;

public class Player implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte[] data;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String account;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Player setId(Long id) {
        this.id = id;
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte[] getData() {
        return data;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Player setData(Byte[] data) {
        this.data = data;
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAccount() {
        return account;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Player setAccount(String account) {
        this.account = account == null ? null : account.trim();
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Player setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", data=").append(data);
        sb.append(", account=").append(account);
        sb.append(", name=").append(name);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Player copy() {
        Player m = new Player(); 
        m.id = this.id;
        m.data = this.data;
        m.account = this.account;
        m.name = this.name;
        return m;
    }
}