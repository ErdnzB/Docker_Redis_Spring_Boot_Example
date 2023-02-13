package com.gaming.advice.exception;

import com.gaming.advice.exception.base.BaseException;
import com.gaming.advice.constants.ErrorCodes;
import org.springframework.http.HttpStatus;


public class NoSuchPlayerException extends BaseException {

    public NoSuchPlayerException() {
        super(HttpStatus.NOT_FOUND, ErrorCodes.NO_SUCH_PLAYER, "No Such Player !");
    }
}
