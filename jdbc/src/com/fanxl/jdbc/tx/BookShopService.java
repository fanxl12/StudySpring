package com.fanxl.jdbc.tx;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 17:36
 */
public interface BookShopService {


    /**
     * 买书
     * @param name
     * @param isbn
     */
    void buyBook(String name, String isbn);

}
