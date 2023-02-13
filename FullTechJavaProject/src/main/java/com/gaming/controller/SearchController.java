package com.gaming.controller;

import com.gaming.enums.PlayerLevels;
import com.gaming.model.dto.RegisterDto;
import com.gaming.service.inteface.IRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/search")
public class SearchController {


    private final IRegisterService IregisterService;

    @GetMapping("/players-by-params")
    private List<RegisterDto> searchPlayersByParams(@RequestParam PlayerLevels playerLevel,
                                                    @RequestParam Long gameId,
                                                    @RequestParam Long regionId) {
        return IregisterService.searchPlayersByParams(playerLevel, gameId, regionId);
    }
}
