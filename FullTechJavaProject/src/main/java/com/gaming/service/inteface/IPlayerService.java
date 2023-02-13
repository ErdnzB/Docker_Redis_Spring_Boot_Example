package com.gaming.service.inteface;

import com.gaming.persistence.entity.PlayerEntity;

public interface IPlayerService {

    PlayerEntity getPlayerEntityById(Long id);
}
