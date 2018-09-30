package com.fanxl.jdbc.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 18:12
 */
@Service(value = "cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void buyList(String name, List<String> isbnList) {

        for (String isbn : isbnList) {
            bookShopService.buyBook(name, isbn);
        }

    }
}
