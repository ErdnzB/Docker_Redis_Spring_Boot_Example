package com.gaming.advice.exception.base;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final int code;
    private final HttpStatus status;

    public BaseException(int code, String message) {
        this(BAD_REQUEST, code, message);
    }

    public BaseException(HttpStatus status, int code, String message) {
        super(message);
        this.code = code;
        this.status = status;
    }


}
