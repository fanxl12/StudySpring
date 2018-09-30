package com.fanxl.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 15:04
 */
public class JDBCTest {

    private ApplicationContext ctx = null;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate)ctx.getBean("namedParameterJdbcTemplate");
    }

    private JdbcTemplate jdbcTemplate;

    /**
     * 可直接通过类来实现
     */
    @Test
    public void testNamedParameterJdbcTemplate2() {
        String sql = "insert into f_school (name) values (:name)";

        School school = new School();
        school.setName("绿杨中学");

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(school);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    /**
     * 可以为参数起名字
     */
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "insert into f_student (name, age) values (:n, :age)";

        Map<String, Object> param = new HashMap<>();
        param.put("n", "BaiCai");
        param.put("age", 22);

        namedParameterJdbcTemplate.update(sql, param);
    }

    @Test
    public void testBatchUpdate() {
        String sql = "insert into f_student (name, age) values (?, ?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"ZhangSan", 20});
        batchArgs.add(new Object[]{"LiSi", 18});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Test
    public void testUpdate() {
        String sql = "update f_user set username = ? where id = ?";
        jdbcTemplate.update(sql, "main_5", 4);
    }

    /**
     * 1.使用SQL中的列的别名完成列名和类的属性名的映射，列如last_name lastName
     * 2.不支持级联属性，jdbcTemplate到底是一个JDBC小工具，不是ORM框架
     */
    @Test
    public void testQueryForObject() {
        String sql = "select id, name, age from f_student where id = ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        Student student = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        Assert.assertEquals(1L, student.getId());
    }

    @Test
    public void testStudentCount() {
        String sql = "select count(id) from f_student";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("学生数量:" + count);
    }

    @Test
    public void testGetStudentAge() {
        String sql = "select age from f_student where id = ?";
        Integer age = jdbcTemplate.queryForObject(sql, Integer.class, 1);
        System.out.println("年龄:" + age);
    }

    @Test
    public void testQueryForList() {
        String sql = "select id, name, age from f_student where id > ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        List<Student> studentList = jdbcTemplate.query(sql, rowMapper, 1);
        Assert.assertEquals(2, studentList.size());
    }

    @Test
    public void testDataSource() throws Exception {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

}
