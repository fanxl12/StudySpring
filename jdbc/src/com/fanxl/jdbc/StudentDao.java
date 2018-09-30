package com.fanxl.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @description 不推荐用JdbcDaoSupport，而推荐直接用JdbcTemplate作为Dao类的成员变量
 * @author: fanxl
 * @date: 2018/9/30 0030 16:00
 */
@Repository
public class StudentDao extends JdbcDaoSupport {

    @Autowired
    public void setDatasource2(DataSource datasource) {
        setDataSource(datasource);
    }

}
