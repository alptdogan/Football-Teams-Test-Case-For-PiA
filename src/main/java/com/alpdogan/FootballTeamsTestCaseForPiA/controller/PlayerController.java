package com.alpdogan.FootballTeamsTestCaseForPiA.controller;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.SavePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.request.UpdatePlayerRequestDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.dto.response.PlayerResponseDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Player;
import com.alpdogan.FootballTeamsTestCaseForPiA.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/findAllPlayers")
    public ResponseEntity<List<PlayerResponseDto>> findAllPlayers() {

        List<PlayerResponseDto> playerResponseDtos = playerService.findAllPlayers();

        return new ResponseEntity<>(playerResponseDtos, HttpStatus.OK);

    }

    @PostMapping("/savePlayer")
    public ResponseEntity<String> savePlayer(@RequestBody SavePlayerRequestDto savePlayerRequestDto) {

        String playerSaveDescription = playerService.savePlayer(savePlayerRequestDto);

        return new ResponseEntity<>(playerSaveDescription, HttpStatus.OK);

    }

    @DeleteMapping("/deletePlayer")
    public ResponseEntity<String> deletePlayerById(@RequestParam Integer playerId) {

        String deletePlayerDescription = playerService.deletePlayerById(playerId);

        return new ResponseEntity<>(deletePlayerDescription, HttpStatus.OK);

    }

}
