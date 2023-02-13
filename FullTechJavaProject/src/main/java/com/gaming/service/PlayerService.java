package com.gaming.service;


import com.gaming.advice.exception.NoSuchPlayerException;
import com.gaming.persistence.entity.PlayerEntity;
import com.gaming.persistence.repository.PlayerRepository;
import com.gaming.service.inteface.IPlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PlayerService implements IPlayerService {

    private final PlayerRepository playerRepository;


    public PlayerEntity getPlayerEntityById(Long id) {
        return playerRepository.findById(id).orElseThrow(NoSuchPlayerException::new);
    }


}
