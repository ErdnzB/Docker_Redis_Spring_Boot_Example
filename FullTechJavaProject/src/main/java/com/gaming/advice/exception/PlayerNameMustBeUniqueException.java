package com.gaming.advice.exception;

import com.gaming.advice.exception.base.BaseException;
import com.gaming.advice.constants.ErrorCodes;
import org.springframework.http.HttpStatus;

public class PlayerNameMustBeUniqueException extends BaseException {

    public PlayerNameMustBeUniqueException() {
        super(HttpStatus.BAD_REQUEST, ErrorCodes.PLAYER_NAME_MUST_BE_UNQ, "Player Name That You Entered Already Defined For This Game.Try Another Name Or Enter Different Game !");
    }
}
