package com.gaming.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class RegionDto implements Serializable {

    private static final long serialVersionUID = 12312323552220L;
    private Long id;
    private String country;
}
