package com.fanxl.study.collections;

import java.util.Properties;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/15 0015 17:07
 */
public class DataSource {

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
