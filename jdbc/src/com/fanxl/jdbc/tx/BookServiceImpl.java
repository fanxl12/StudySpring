package com.fanxl.jdbc.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 17:36
 */
@Service(value = "bookService")
public class BookServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 使用propagation指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时
     * 如果使用事务， 默认取值REQUIRED 使用上一个事务方法的事务
     * REQUIRES_NEW 使用自己的事务，调用的方法的事务被挂起
     * @param name
     * @param isbn
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void buyBook(String name, String isbn) {

        BigDecimal price = bookShopDao.findBookPriceByIsbn(isbn);

        bookShopDao.updateBookStock(isbn);

        bookShopDao.updateUserBalance(name, price);

    }
}
