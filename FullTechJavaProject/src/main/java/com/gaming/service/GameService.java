package com.gaming.service;

import com.gaming.advice.exception.NoDefinedGamesException;
import com.gaming.advice.exception.NoSuchGameException;
import com.gaming.converter.GameConverter;
import com.gaming.model.dto.GameDto;
import com.gaming.persistence.entity.GameEntity;
import com.gaming.persistence.repository.GameRepository;
import com.gaming.service.inteface.IGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.gaming.config.redis.constants.RedisConstantsNames.GAME_SEARCH_BY_ID_CACHE;

@Slf4j
@RequiredArgsConstructor
@Service
public class GameService implements IGameService {

    private final GameRepository gameRepository;

    @Cacheable(value = GAME_SEARCH_BY_ID_CACHE)
    public GameEntity getGameEntityById(Long id) {
        Optional<GameEntity> byId = Optional.of(gameRepository.findById(id).orElseThrow(NoSuchGameException::new));
        return byId.get();
    }

    public List<GameDto> getAllActiveGameIds() {
        return getAllActiveGameEntities().stream().map(GameConverter::gameDto).collect(Collectors.toList());
    }

    private List<GameEntity> getAllActiveGameEntities() {
        return Optional.of(gameRepository.findByActive(true)).orElseThrow(NoDefinedGamesException::new);
    }


}
