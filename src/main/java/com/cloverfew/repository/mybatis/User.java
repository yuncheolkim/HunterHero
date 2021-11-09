package com.cloverfew.repository.mybatis;

import java.io.Serializable;
import javax.annotation.Generated;

public class User implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String account;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAccount() {
        return account;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User setAccount(String account) {
        this.account = account == null ? null : account.trim();
        return this;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPassword() {
        return password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public User setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public User copy() {
        User m = new User(); 
        m.id = this.id;
        m.account = this.account;
        m.password = this.password;
        return m;
    }
}