package com.gaming.service;

import com.gaming.advice.exception.AlreadyLinkedPlayerException;
import com.gaming.advice.exception.PlayerNameMustBeUniqueException;
import com.gaming.converter.RegisterConverter;
import com.gaming.enums.PlayerLevels;
import com.gaming.model.dto.DummyLogCacheDto;
import com.gaming.model.dto.RegisterDto;
import com.gaming.model.request.PlayerLinkCreateRequest;
import com.gaming.persistence.entity.RegisterEntity;
import com.gaming.persistence.repository.RegisterRepository;
import com.gaming.persistence.specification.RegisterSpecification;
import com.gaming.service.inteface.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.gaming.config.redis.constants.RedisConstantsNames.SEARCH_BY_PARAMS_WITH_KEYS_CACHE;

@Slf4j
@RequiredArgsConstructor
@Service
public class RegisterService implements IRegisterService {

    private final RegisterRepository repository;

    private final IRegionService IregionService;

    private final IGameService IgameService;

    private final IPlayerService IplayerService;

    private final IDummyLogCacheService IDummyLogCacheService;


    public void linkPlayerToGame(PlayerLinkCreateRequest createRequest) {

        assertGameIdRegionIdAndPlayerNameIsValid(createRequest.getGameId(), createRequest.getPlayerId(), createRequest.getRegionId());
        assertGameIdAndPlayerNameIsValid(createRequest.getGameId(), createRequest.getPlayerId());

        RegisterEntity entity = new RegisterEntity();
        entity.setGame(IgameService.getGameEntityById(createRequest.getGameId()));
        entity.setRegion(IregionService.getRegionEntityById(createRequest.getRegionId()));
        entity.setPlayerLevel(PlayerLevels.valueOf(createRequest.getPlayerLevel().toUpperCase(Locale.ROOT)));
        entity.setPlayer(IplayerService.getPlayerEntityById(createRequest.getPlayerId()));
        repository.save(entity);
    }

    public Map<String, List<RegisterDto>> getPlayersForPerGameByLevel(PlayerLevels playerLevel) {
        Map<String, List<RegisterDto>> result = new HashMap<>();
        IgameService.getAllActiveGameIds().forEach(gameDto -> {
            result.put(gameDto.getGameName(), getAllPlayerByGameIdAndLevel(playerLevel, gameDto.getId()));
        });
        return result;
    }

    @Cacheable(value = SEARCH_BY_PARAMS_WITH_KEYS_CACHE, key = "{#gameId,#regionId}", unless = "#result == null")
    public List<RegisterDto> searchPlayersByParams(PlayerLevels playerLevel, Long gameId, Long regionId) {

        IDummyLogCacheService.saveGuardData(DummyLogCacheDto.builder()
                .logReason("SEARCH LOG HAS RECEIVED")
                .params(playerLevel.toString() + gameId.toString() + regionId.toString())
                .build());

        return repository.findAll(RegisterSpecification.filter(gameId, null, regionId, playerLevel))
                .stream()
                .map(RegisterConverter::registerDto).collect(Collectors.toList());
    }


    private List<RegisterDto> getAllPlayerByGameIdAndLevel(PlayerLevels playerLevel, Long gameId) {
        return repository.findAll(RegisterSpecification.filter(gameId, null, null, playerLevel)).stream()
                .map(RegisterConverter::registerDto).collect(Collectors.toList());
    }

    private void assertGameIdRegionIdAndPlayerNameIsValid(final Long gameId, final Long playerId, final Long regionId) {
        Optional<RegisterEntity> registerEntity = Optional.ofNullable(repository.findByGame_IdAndPlayer_IdAndRegion_Id(
                gameId,
                playerId,
                regionId));
        if (registerEntity.isPresent()) {
            throw new AlreadyLinkedPlayerException();
        }
    }

    private void assertGameIdAndPlayerNameIsValid(final Long gameId, final Long playerId) {
        Optional<RegisterEntity> registerEntity = Optional.ofNullable(repository.findByGame_IdAndPlayer_Id(
                gameId,
                playerId));
        if (registerEntity.isPresent()) {
            throw new PlayerNameMustBeUniqueException();
        }
    }


}

