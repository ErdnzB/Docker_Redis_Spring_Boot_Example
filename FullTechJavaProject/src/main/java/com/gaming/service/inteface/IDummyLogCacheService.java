package com.gaming.service.inteface;

import com.gaming.model.dto.DummyLogCacheDto;

public interface IDummyLogCacheService {

     void saveGuardData(DummyLogCacheDto logReason);

     void evictOldGameSearch(Integer logNumber);
}
