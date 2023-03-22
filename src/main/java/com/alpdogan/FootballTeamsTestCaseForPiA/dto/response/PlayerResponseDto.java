package com.alpdogan.FootballTeamsTestCaseForPiA.dto.response;

import lombok.Data;

@Data
public class PlayerResponseDto {

    private int id;

    private String fullName;

    private boolean isForeigner;

    private boolean isGoalkeeper;

    private int teamId;

}
