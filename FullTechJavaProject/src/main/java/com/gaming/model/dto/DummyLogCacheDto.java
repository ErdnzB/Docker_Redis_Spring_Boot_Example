package com.gaming.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Builder
public class DummyLogCacheDto implements Serializable {


    private static final long serialVersionUID = 123182123552220L;
    private String logReason;
    private String params;

}


