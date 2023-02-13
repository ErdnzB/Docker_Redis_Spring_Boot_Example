package com.gaming.model.dto;

import com.gaming.enums.PlayerLevels;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class RegisterDto implements Serializable {

    private static final long serialVersionUID = 42322322552220L;
    private Long id;
    private Long playerId;
    private Long gameId;
    private Long regionId;
    private PlayerLevels playerLevel;

}
