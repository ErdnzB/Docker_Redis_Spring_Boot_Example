package com.gaming.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GeneratorUtils {

    public static int randomNumberGenerator() {
        double doubleNumberRandom = 5 + (Math.random() * (15 - 5));
        return (int) doubleNumberRandom;
    }
}
