package com.alpdogan.FootballTeamsTestCaseForPiA.service;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SaveTeamRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Team;
import com.alpdogan.FootballTeamsTestCaseForPiA.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

    @InjectMocks
    TeamService teamService;

    @Mock
    TeamRepository teamRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    void testSaveTeam() {

        SaveTeamRequestDto saveTeamRequestDtoMock = mock(SaveTeamRequestDto.class);

        saveTeamRequestDtoMock.setTeamName("testName");

        Team teamMock = mock(Team.class);
        teamMock.setId(1);

        when(modelMapper.map(saveTeamRequestDtoMock, Team.class)).thenReturn(teamMock);
        when(teamRepository.save(teamMock)).thenReturn(teamMock);
        String saveTeam = teamService.saveTeam(saveTeamRequestDtoMock);
        String saveTeamMessage = teamMock.getTeamName() + " Has Been Created Successfully.";

        assertEquals(saveTeamMessage, saveTeam);

    }

    @Test
    void testFindTeamById(){

        Team teamMock = mock(Team.class);

        teamMock.setId(1);
        teamMock.setTeamName("Galatasaray");

        when(teamRepository.findById(teamMock.getId())).thenReturn(Optional.of(teamMock));
        Team findTeam = teamService.findTeamById(teamMock.getId());

        assertEquals(teamMock, findTeam);

    }


}
