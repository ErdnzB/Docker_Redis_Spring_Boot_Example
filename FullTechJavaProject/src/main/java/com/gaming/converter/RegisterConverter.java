package com.gaming.converter;

import com.gaming.model.dto.RegisterDto;
import com.gaming.persistence.entity.RegisterEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterConverter {

    public static RegisterDto registerDto(final RegisterEntity registerEntity) {
        return RegisterDto.builder()
                .id(registerEntity.getId())
                .gameId(registerEntity.getGame().getId())
                .regionId(registerEntity.getRegion().getId())
                .playerId(registerEntity.getPlayer().getId())
                .playerLevel(registerEntity.getPlayerLevel())
                .build();
    }
}