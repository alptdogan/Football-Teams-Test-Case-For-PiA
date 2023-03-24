package com.alpdogan.FootballTeamsTestCaseForPiA.dto.request;

import lombok.Data;

@Data
public class SavePlayerRequestDto {

    private String fullName;

    //private boolean isForeigner;

    //private boolean isGoalkeeper;

    private int teamId;

}
