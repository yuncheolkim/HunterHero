package com.cloverfew.repository;

import javax.sql.DataSource;

/**
 * @author Yunzhe.Jin
 * 2021/8/21 15:31
 */
public interface DataSourceFactory {
    DataSource create();
}
