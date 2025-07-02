package com.angelogomez.slci.api.domain.exception;

import java.util.Date;

public class BadRequestException extends RuntimeException {

    private Date timestStamp;
    private Integer statusCode;
    private String error;
    private String message;
    private String path;

    public BadRequestException(String message) {
        this.message = message;
    }

}
