package com.fanxl.jdbc;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 15:33
 */
public class Student {

    private long id;

    private String name;

    private Integer age;

    private School school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
