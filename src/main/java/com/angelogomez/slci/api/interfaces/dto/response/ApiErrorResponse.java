package com.angelogomez.slci.api.interfaces.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ApiErrorResponse {
    private Date timestStamp;
    private Integer statusCode;
    private String error;
    private String message;
    private String path;
}
