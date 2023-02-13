package com.gaming.controller;


import com.gaming.enums.PlayerLevels;
import com.gaming.model.dto.RegisterDto;
import com.gaming.model.request.PlayerLinkCreateRequest;
import com.gaming.service.inteface.IRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    private final IRegisterService IregisterService;

    @PostMapping("/link-player")
    private void linkPlayerToGame(@Valid @RequestBody PlayerLinkCreateRequest createRequest) {
        IregisterService.linkPlayerToGame(createRequest);
    }

    @GetMapping("/all-players-by-level")
    private Map<String, List<RegisterDto>> getPlayersForPerGameByLevel(@RequestParam PlayerLevels playerLevel) {
        return IregisterService.getPlayersForPerGameByLevel(playerLevel);
    }


}
