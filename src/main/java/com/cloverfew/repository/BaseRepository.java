package com.cloverfew.repository;

import org.apache.ibatis.session.SqlSessionFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Yunzhe.Jin
 * 2021/8/21 12:50
 */
public class BaseRepository<T> {

    private final Class<T> type;

    private SqlSessionFactory factory;

    public BaseRepository() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        type = (Class) ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    protected SqlSessionFactory factory() {
        return factory;
    }

    public T mapper() {
        return factory().openSession(true).getMapper(type);
    }

    public Class<T> getType() {
        return type;
    }

    public void setFactory(SqlSessionFactory factory) {
        this.factory = factory;
        factory.getConfiguration().addMapper(getType());
    }
}
