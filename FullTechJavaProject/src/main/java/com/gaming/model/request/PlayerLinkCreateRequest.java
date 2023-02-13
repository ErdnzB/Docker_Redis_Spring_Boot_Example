package com.gaming.model.request;

import com.gaming.advice.validate.EnumValidator;
import com.gaming.enums.PlayerLevels;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerLinkCreateRequest {


    @NotNull
    private Long gameId;

    @NotNull
    private Long regionId;

    @NotNull
    private Long playerId;

    @NotEmpty
    @EnumValidator(enumClazz = PlayerLevels.class, message = "Invalid Player Level Definition")
    private String playerLevel;

}




