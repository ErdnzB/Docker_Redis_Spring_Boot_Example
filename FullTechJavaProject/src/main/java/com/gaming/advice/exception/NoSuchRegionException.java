package com.gaming.advice.exception;

import com.gaming.advice.exception.base.BaseException;
import com.gaming.advice.constants.ErrorCodes;
import org.springframework.http.HttpStatus;

public class NoSuchRegionException extends BaseException {

    public NoSuchRegionException() {
        super(HttpStatus.NOT_FOUND, ErrorCodes.NO_SUCH_REGION, "No Such Region !");
    }
}
