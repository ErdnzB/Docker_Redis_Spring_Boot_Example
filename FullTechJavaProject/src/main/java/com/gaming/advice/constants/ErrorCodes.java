package com.gaming.advice.constants;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCodes {

    public static final int NO_SUCH_PLAYER_LEVEL = 10100;

    public static final int NO_SUCH_REGION = 10101;

    public static final int NO_DEFINED_GAME = 10102;

    public static final int NO_SUCH_GAME = 10103;

    public static final int ALREADY_LINKED_PLAYER = 10104;

    public static final int PLAYER_NAME_MUST_BE_UNQ = 10105;

    public static final int NO_SUCH_PLAYER = 10106;

}
