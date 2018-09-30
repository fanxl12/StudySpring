package com.fanxl.jdbc.tx;

import java.util.List;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 18:11
 */
public interface Cashier {

    /**
     * 买多本书
     * @param name
     * @param isbnList
     */
    void buyList(String name, List<String> isbnList);


}
