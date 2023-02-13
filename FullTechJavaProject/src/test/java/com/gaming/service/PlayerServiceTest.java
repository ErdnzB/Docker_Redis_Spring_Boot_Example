package com.gaming.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    /*
    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private IRegionService IregionService;

    @Mock
    private IGameService IgameService;

    @Test
    void it_should_link_player_to_game() {
        final Long gameId = 1L;
        final Long regionId = 1L;
        final String playerName = "Name";

        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setId(regionId);
        regionEntity.setCountry("UK");

        GameEntity gameEntity = new GameEntity();
        gameEntity.setId(gameId);
        gameEntity.setName("Fun Game");
        gameEntity.setActive(true);
        gameEntity.setDescription("Description");
        gameEntity.setExternalId("1223-23123-221-1232");

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setGame(gameEntity);
        playerEntity.setRegion(regionEntity);
        playerEntity.setName(playerName);
        playerEntity.setPlayerLevel(PlayerLevels.NOOB);
        playerEntity.setId(2L);

        PlayerLinkCreateRequest request = new PlayerLinkCreateRequest(playerName, gameId, regionId, "noob");

        when(IregionService.getRegionEntityById(regionId)).thenReturn(regionEntity);
        when(IgameService.getGameEntityById(gameId)).thenReturn(gameEntity);
        when(playerRepository.save(any())).thenReturn(playerEntity);
        playerService.linkPlayerToGame(request);


    }


    @Test
    void it_should_return_exception_1_region_entity_by_id() throws AlreadyLinkedPlayerException {
        final Long gameId = 1L;
        final Long regionId = 1L;
        final String playerName = "Name";


        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setId(regionId);
        regionEntity.setCountry("UK");

        GameEntity gameEntity = new GameEntity();
        gameEntity.setId(gameId);
        gameEntity.setName("Fun Game");
        gameEntity.setActive(true);
        gameEntity.setDescription("Description");
        gameEntity.setExternalId("1223-23123-221-1232");

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setGame(gameEntity);
        playerEntity.setRegion(regionEntity);
        playerEntity.setName(playerName);
        playerEntity.setPlayerLevel(PlayerLevels.NOOB);
        playerEntity.setId(2L);

        PlayerLinkCreateRequest request = new PlayerLinkCreateRequest(playerName, gameId, regionId, "noob");
        AlreadyLinkedPlayerException exception = assertThrows(AlreadyLinkedPlayerException.class, () -> {
            when(playerRepository.findByGame_IdAndNameAndRegion_Id(
                    gameId,
                    playerName, regionId)).thenReturn(playerEntity);
            playerService.linkPlayerToGame(request);
        });

        String expectedMessage = "Player That You Entered Already Defined For This Game And Region.Pls Try Different Game,Name Or Region !";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void it_should_return_exception_2_region_entity_by_id() throws PlayerNameMustBeUniqueException {
        final Long gameId = 1L;
        final Long regionId = 1L;
        final String playerName = "Name";


        RegionEntity regionEntity = new RegionEntity();
        regionEntity.setId(regionId);
        regionEntity.setCountry("UK");

        GameEntity gameEntity = new GameEntity();
        gameEntity.setId(gameId);
        gameEntity.setName("Fun Game");
        gameEntity.setActive(true);
        gameEntity.setDescription("Description");
        gameEntity.setExternalId("1223-23123-221-1232");

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setGame(gameEntity);
        playerEntity.setRegion(regionEntity);
        playerEntity.setName(playerName);
        playerEntity.setPlayerLevel(PlayerLevels.NOOB);
        playerEntity.setId(2L);

        PlayerLinkCreateRequest request = new PlayerLinkCreateRequest(playerName, gameId, regionId, "noob");
        PlayerNameMustBeUniqueException exception = assertThrows(PlayerNameMustBeUniqueException.class, () -> {
            when(playerRepository.findByGame_IdAndName(
                    gameId,
                    playerName)).thenReturn(playerEntity);
            playerService.linkPlayerToGame(request);
        });

        String expectedMessage = "Player Name That You Entered Already Defined For This Game.Try Another Name Or Enter Different Game !";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void it_should_return_players_by_level() {
        List<GameDto> gameDtos = new ArrayList<>();
        GameDto first_game = GameDto.builder().id(1L).gameName("First Game").build();
        GameDto second_game = GameDto.builder().id(2L).gameName("Second Game").build();
        gameDtos.add(first_game);
        gameDtos.add(second_game);

        when(IgameService.getAllActiveGameIds()).thenReturn(gameDtos);
        playerService.getPlayersForPerGameByLevel(PlayerLevels.NOOB);
    }

    @Test
    void it_should_return_players_by_params() {
        final Long gameId = 1L;
        final Long regionId = 1L;
        List<PlayerEntity> playerEntityList = new ArrayList<>();
        PlayerEntity playerEntity_1 = new PlayerEntity();
        playerEntity_1.setId(1L);
        playerEntity_1.setRegion(new RegionEntity());
        playerEntity_1.setGame(new GameEntity());
        playerEntity_1.setName("Name");
        playerEntity_1.setPlayerLevel(PlayerLevels.PRO);
        playerEntityList.add(playerEntity_1);

        when(playerRepository.findByGame_IdAndPlayerLevelAndRegion_Id(gameId, PlayerLevels.PRO, regionId)).thenReturn(playerEntityList);
        playerService.searchPlayersByParams(PlayerLevels.PRO, gameId, regionId);
    }  */


}
