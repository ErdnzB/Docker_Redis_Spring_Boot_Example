package com.gaming.enums;

import com.gaming.advice.exception.NoSuchLevelTypeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum PlayerLevels {

    NOOB(0),
    PRO(1),
    INVINCIBLE(2);

    private Integer type;

    public static PlayerLevels fromValue(Integer value) {
        return Arrays.stream(PlayerLevels.values())
                .filter(e -> e.type.equals(value))
                .findFirst()
                .orElseThrow(NoSuchLevelTypeException::new);
    }


}
