package com.gaming.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class GameDto implements Serializable {

    private static final long serialVersionUID = 123187523552220L;
    private Long id;
    private String gameName;
    private String description;
    private String externalId;
    private Boolean isActive;
}
