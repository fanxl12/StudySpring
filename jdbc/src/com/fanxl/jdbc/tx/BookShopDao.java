package com.fanxl.jdbc.tx;

import java.math.BigDecimal;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 16:43
 */
public interface BookShopDao {

    /**
     * 查找书的单价
     * @param isbn
     * @return
     */
    BigDecimal findBookPriceByIsbn(String isbn);

    /**
     * 更新库的库存
     * @param isbn
     */
    void updateBookStock(String isbn);

    /**
     * 更新用户账户余额
     * @param name
     * @param price
     */
    void updateUserBalance(String name, BigDecimal price);




}
