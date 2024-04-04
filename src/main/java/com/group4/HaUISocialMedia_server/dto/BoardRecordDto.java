package com.group4.HaUISocialMedia_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRecordDto {
    private UUID id;
    private UserDto user;

    private Integer numsOfA;

    private Integer numsOfBPlus;

    private Integer numsOfB;

    private Integer numsOfCPlus;

    private Integer numsOfC;

    private Integer numsOfDPlus;

    private Integer numsOfD;
}
