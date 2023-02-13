package com.gaming.service.inteface;

import com.gaming.persistence.entity.RegionEntity;

public interface IRegionService {

    RegionEntity getRegionEntityById(Long id);
}
