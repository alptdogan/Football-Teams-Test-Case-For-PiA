package com.alpdogan.FootballTeamsTestCaseForPiA.controller;

import com.alpdogan.FootballTeamsTestCaseForPiA.dto.response.PlayerResponseDto;
import com.alpdogan.FootballTeamsTestCaseForPiA.entity.Player;
import com.alpdogan.FootballTeamsTestCaseForPiA.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/findPlayerById")
    public ResponseEntity<Player> findPlayerById(@RequestParam Integer playerId) {

        Player player = playerService.findPlayerById(playerId);

        return new ResponseEntity<>(player, HttpStatus.OK);

    }

    @GetMapping("/findAllPlayers")
    public ResponseEntity<List<PlayerResponseDto>> findAllPlayers() {

        List<PlayerResponseDto> playerResponseDtos = playerService.findAllPlayers();

        return new ResponseEntity<>(playerResponseDtos, HttpStatus.OK);

    }

}
