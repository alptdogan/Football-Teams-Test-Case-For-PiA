package com.alpdogan.FootballTeamsTestCaseForPiA.dto.request;

import lombok.Data;

@Data
public class UpdatePlayerRequestDto {

    private int id;

    private String fullName;

    private boolean isForeigner;

    private boolean isGoalkeeper;

    private int teamId;

}
