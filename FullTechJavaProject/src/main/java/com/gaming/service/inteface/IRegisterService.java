package com.gaming.service.inteface;

import com.gaming.enums.PlayerLevels;
import com.gaming.model.dto.RegisterDto;
import com.gaming.model.request.PlayerLinkCreateRequest;

import java.util.List;
import java.util.Map;

public interface IRegisterService {

    void linkPlayerToGame(PlayerLinkCreateRequest createRequest);

    Map<String, List<RegisterDto>> getPlayersForPerGameByLevel(PlayerLevels playerLevel);

    List<RegisterDto> searchPlayersByParams(PlayerLevels playerLevel, Long gameId, Long regionId);
}
