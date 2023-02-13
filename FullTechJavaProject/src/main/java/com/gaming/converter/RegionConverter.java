package com.gaming.converter;

import com.gaming.model.dto.RegionDto;
import com.gaming.persistence.entity.RegionEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegionConverter {

    public static RegionDto regionDto(final RegionEntity regionEntity) {
        return RegionDto.builder()
                .id(regionEntity.getId())
                .country(regionEntity.getCountry())
                .build();
    }
}
