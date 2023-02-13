package com.gaming.converter;

import com.gaming.model.dto.GameDto;
import com.gaming.persistence.entity.GameEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameConverter {

    public static GameDto gameDto(final GameEntity gameEntity) {
        return GameDto.builder()
                .id(gameEntity.getId())
                .description(gameEntity.getDescription())
                .gameName(gameEntity.getName())
                .externalId(gameEntity.getExternalId())
                .isActive(gameEntity.isActive())
                .build();
    }
}
