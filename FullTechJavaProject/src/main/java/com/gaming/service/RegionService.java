package com.gaming.service;

import com.gaming.advice.exception.NoSuchRegionException;
import com.gaming.persistence.entity.RegionEntity;
import com.gaming.persistence.repository.RegionRepository;
import com.gaming.service.inteface.IRegionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegionService implements IRegionService {

    private final RegionRepository regionRepository;

    public RegionEntity getRegionEntityById(Long id) {
        return regionRepository.findById(id).orElseThrow(NoSuchRegionException::new);
    }


}
