package com.fanxl.jdbc.tx;

/**
 * @description
 * @author: fanxl
 * @date: 2018/9/30 0030 17:29
 */
public class BookException extends RuntimeException {

    public BookException() {
        super();
    }

    public BookException(String message) {
        super(message);
    }

    public BookException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookException(Throwable cause) {
        super(cause);
    }
}
