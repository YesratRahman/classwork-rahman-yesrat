package com.tp.connectFour.controller;

import com.tp.connectFour.model.ConnectFourGame;
import com.tp.connectFour.model.MoveRequest;
import com.tp.connectFour.service.ConnectFourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConnectFourController {

    @Autowired
    ConnectFourService connectFourService;

    @GetMapping("/game/{gameId}")
    public ConnectFourGame getBoard(@PathVariable Integer gameId){
        return connectFourService.getGameById(gameId);
    }

    @GetMapping("/game")
    public List<ConnectFourGame> allBoard(){
        return connectFourService.getAllGames();
    }

    @PostMapping("/makeMove" )
    public ResponseEntity makeMove(@RequestBody MoveRequest request){
        return ResponseEntity.ok(connectFourService.makeMove(request));

    }

    @PostMapping("/begin")
    public ResponseEntity startGame( ){
        return ResponseEntity.ok(connectFourService.startGame());

    }

    @DeleteMapping("/delete/{gameId}")
        public String deleteGame(@PathVariable Integer gameId){
        throw new UnsupportedOperationException();
    }




}
