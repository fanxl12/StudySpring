package com.fanxl.jdbc.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 16:48
 */
@Repository(value = "bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BigDecimal findBookPriceByIsbn(String isbn) {
        String sql = "select price from f_book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class, isbn);
    }

    @Override
    public void updateBookStock(String isbn) {
        String stockSql = "select stock from f_book_stock where isbn = ?";
        int stock = jdbcTemplate.queryForObject(stockSql, Integer.class, isbn);
        if (stock == 0) {
            throw new BookException("库存不足");
        }
        String sql = "update f_book_stock set stock = stock -1 where isbn = ?";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateUserBalance(String name, BigDecimal price) {
        String priceSql = "select balance from f_student where name = ?";
        BigDecimal balance = jdbcTemplate.queryForObject(priceSql, BigDecimal.class, name);
        if (balance.compareTo(price) == -1) {
            throw new BookException("余额不足");
        }
        String sql = "update f_student set balance = balance - ? where name = ?";
        jdbcTemplate.update(sql, price, name);
    }
}
