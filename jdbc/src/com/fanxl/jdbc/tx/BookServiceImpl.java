package com.fanxl.jdbc.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void buyBook(String name, String isbn) {

        BigDecimal price = bookShopDao.findBookPriceByIsbn(isbn);

        bookShopDao.updateBookStock(isbn);

        bookShopDao.updateUserBalance(name, price);

    }
}
