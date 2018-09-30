package com.fanxl.jdbc.tx;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 15:04
 */
public class TXTest {

    private ApplicationContext ctx = null;

    private BookShopDao bookShopDao;

    private BookShopService bookShopService;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopDao = (BookShopDao) ctx.getBean("bookShopDao");
        bookShopService = ctx.getBean(BookShopService.class);
    }

    @Test
    public void buy() {
        bookShopService.buyBook("ZhangSan", "123");
    }

    @Test
    public void testFindPriceByIsbn() {
        BigDecimal price = bookShopDao.findBookPriceByIsbn("123");
        Assert.assertEquals(25.0, price.doubleValue(), 0.1);
    }

    @Test
    public void testStock() {
        bookShopDao.updateBookStock("145");
    }





}
