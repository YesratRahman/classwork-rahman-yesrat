package com.tp.connectFour.service;

import com.tp.connectFour.controller.ConnectFourController;
import com.tp.connectFour.model.ConnectFourGame;
import com.tp.connectFour.model.MoveRequest;
import com.tp.connectFour.persistence.ConnectFourDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConnectFourService {


    @Autowired
    ConnectFourDao connectFourDao;

    public ConnectFourGame getGameById(Integer game){

        return connectFourDao.getGameById(game);
    }

    public List<ConnectFourGame> getAllGames(){
        return connectFourDao.getAllGames();
    }


    public ConnectFourGame makeMove(MoveRequest request) {
        return null;
    }

    public Integer startGame() {
        return connectFourDao.startGame();
    }

    public String buildBoard(Integer[][] grid){
        //StringBuilder str = new StringBuilder();

        throw new UnsupportedOperationException(); 
    }

}
