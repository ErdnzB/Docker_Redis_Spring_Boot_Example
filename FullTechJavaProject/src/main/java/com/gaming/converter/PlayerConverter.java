package com.gaming.converter;

import com.gaming.model.dto.PlayerDto;
import com.gaming.persistence.entity.PlayerEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerConverter {

    public static PlayerDto playerDto(final PlayerEntity playerEntity) {
        return PlayerDto.builder()
                .id(playerEntity.getId())
                .name(playerEntity.getName())
                .build();

    }
}
