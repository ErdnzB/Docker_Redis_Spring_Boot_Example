package com.gaming.service;

import com.gaming.advice.exception.NoSuchGameException;
import com.gaming.persistence.entity.GameEntity;
import com.gaming.persistence.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @InjectMocks
    private GameService gameService;

    @Mock
    private GameRepository gameRepository;


    @Test()
    void it_should_return_game_entity_by_id() {
        final Long id = 1L;
        GameEntity entity = new GameEntity();
        entity.setId(1L);
        entity.setName("Dummy");
        when(gameRepository.findById(id)).thenReturn(Optional.of(entity));
        gameService.getGameEntityById(id);

    }

    @Test()
    void it_should_return_exception_game_entity_by_id() throws NoSuchGameException {
        final Long id = 1L;

        NoSuchGameException exception = assertThrows(NoSuchGameException.class, () -> {
            when(gameRepository.findById(id)).thenReturn(Optional.empty());
            gameService.getGameEntityById(id);
        });

        String expectedMessage = "No Such Game With That ID !";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }


    @Test
    void it_should_return_all_active_game_Ids() {
        List<GameEntity> gameEntityList = new ArrayList<>();
        GameEntity entity = new GameEntity();
        entity.setId(1L);
        entity.setName("Dummy");
        gameEntityList.add(entity);
        when(gameRepository.findByActive(true)).thenReturn(gameEntityList);
        gameService.getAllActiveGameIds();
    }


}



