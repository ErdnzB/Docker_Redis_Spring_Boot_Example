package com.gaming.service.inteface;

import com.gaming.model.dto.GameDto;
import com.gaming.persistence.entity.GameEntity;

import java.util.List;

public interface IGameService {

    GameEntity getGameEntityById(Long id);

    List<GameDto> getAllActiveGameIds();

}
