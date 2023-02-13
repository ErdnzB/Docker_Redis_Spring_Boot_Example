package com.gaming.advice.exception;

import com.gaming.advice.exception.base.BaseException;
import com.gaming.advice.constants.ErrorCodes;
import org.springframework.http.HttpStatus;

public class NoSuchLevelTypeException extends BaseException {

    public NoSuchLevelTypeException() {
        super(HttpStatus.NOT_FOUND, ErrorCodes.NO_SUCH_PLAYER_LEVEL, "No Such Level Type !");
    }
}
