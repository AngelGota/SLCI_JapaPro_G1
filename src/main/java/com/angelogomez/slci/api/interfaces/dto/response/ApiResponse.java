package com.angelogomez.slci.api.interfaces.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private Object data;
    private String message;
    private boolean success;

}
