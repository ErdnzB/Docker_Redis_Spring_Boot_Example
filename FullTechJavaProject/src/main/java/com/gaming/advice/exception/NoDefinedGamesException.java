package com.gaming.advice.exception;

import com.gaming.advice.exception.base.BaseException;
import com.gaming.advice.constants.ErrorCodes;
import org.springframework.http.HttpStatus;

public class NoDefinedGamesException extends BaseException {

    public NoDefinedGamesException() {
        super(HttpStatus.NOT_FOUND, ErrorCodes.NO_DEFINED_GAME, "There Is None Game Defined!");
    }
}
