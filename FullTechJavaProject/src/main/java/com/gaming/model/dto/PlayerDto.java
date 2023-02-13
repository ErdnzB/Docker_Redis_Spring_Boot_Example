package com.gaming.model.dto;

import com.gaming.enums.PlayerLevels;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class PlayerDto implements Serializable {

    private static final long serialVersionUID = 42322323552220L;
    private Long id;
    private String name;
    private Long gameId;
    private Long regionId;
    private PlayerLevels playerLevel;

}
