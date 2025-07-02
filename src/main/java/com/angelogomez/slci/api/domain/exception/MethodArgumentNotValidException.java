package com.angelogomez.slci.api.domain.exception;

public class MethodArgumentNotValidException extends RuntimeException {
    private final String message;

    public MethodArgumentNotValidException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
