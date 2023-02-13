package com.gaming.advice.exception;

import com.gaming.advice.exception.base.BaseException;
import com.gaming.advice.constants.ErrorCodes;
import org.springframework.http.HttpStatus;

public class NoSuchGameException extends BaseException {


    public NoSuchGameException() {
        super(HttpStatus.NOT_FOUND, ErrorCodes.NO_SUCH_GAME, "No Such Game With That ID !");
    }
}
