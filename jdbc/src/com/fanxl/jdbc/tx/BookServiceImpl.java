package com.fanxl.jdbc.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
     * isolation 指定事务的隔离级别，最常用的取值为READ_COMMITTED 读已提交
     * readOnly 是否是只读事务，表示一个事务只读数据不更新数据，设置只读事务可以提高性能
     * timeout 指定强制回滚之前事务可以占用的时间, 如果业务在指定时间内未完成就会强制回滚
     * @param name
     * @param isbn
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW,
        isolation = Isolation.READ_COMMITTED,
        readOnly = false,
        timeout = 1)
    @Override
    public void buyBook(String name, String isbn) {

        BigDecimal price = bookShopDao.findBookPriceByIsbn(isbn);

        bookShopDao.updateBookStock(isbn);

        bookShopDao.updateUserBalance(name, price);

    }
}
