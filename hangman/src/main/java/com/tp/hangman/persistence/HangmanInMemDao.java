package com.tp.hangman.persistence;

import com.tp.hangman.exceptions.InvalidGameIdException;
import com.tp.hangman.exceptions.NullWordException;
import com.tp.hangman.models.HangmanGame;
import com.tp.hangman.models.HangmanViewModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class HangmanInMemDao implements HangmanDao {

    //Map<Integer, HangmanGame> allGames;

    private List<HangmanGame> allGames = new ArrayList<>();

    public HangmanInMemDao(){
        HangmanGame onlyGame = new HangmanGame( 100, "zebra" );
        allGames.add( onlyGame );
    }

    @Override
    public int startGame(String word) throws NullWordException {

        if( word == null ) {
            throw new NullWordException("Tried to start a game with a null word.");
        }

        int id = 0;

        for( HangmanGame toCheck : allGames ){
            if( toCheck.getGameId() > id ){
                id = toCheck.getGameId();
            }
        }

        id++;

        HangmanGame toAdd = new HangmanGame( id, word );
        allGames.add( toAdd );
        return id;


    }

    @Override
    public void deleteGame(Integer gameId) throws InvalidGameIdException {

        int removeIndex = -1;

        for( int i = 0; i < allGames.size(); i++ ){
            if( allGames.get(i).getGameId().equals(gameId)){
                removeIndex = i;
                break;
            }
        }
        if( removeIndex != -1 ){
            allGames.remove(removeIndex);
        } else {
            throw new InvalidGameIdException("Could not find game with id " + gameId + "to delete.");
        }
    }

    @Override
    public List<HangmanGame> getAllGames() {
        List<HangmanGame> copyList = new ArrayList<>();
        for( HangmanGame toCopy : allGames ){
            copyList.add( new HangmanGame(toCopy) );
        }
        return copyList;
    }


    @Override
    public HangmanGame getGameById(Integer gameId) {

        HangmanGame toReturn = null;

        for( HangmanGame toCheck : allGames ){
            if( toCheck.getGameId().equals( gameId) ){
                toReturn = new HangmanGame(toCheck);
                break;
            }
        }

        return toReturn;

        //return allGames.stream().filter( g -> g.getGameId().equals(gameId) ).findFirst().orElse(null);
    }


    @Override
    public void updateGame(HangmanGame game) {

        for( int i = 0; i < allGames.size(); i++){
            if( allGames.get(i).getGameId().equals(game.getGameId())){
                //we found the game to update
                allGames.set(i, new HangmanGame(game) );
            }
        }

    }



//    public List<HangmanGame> getVowelGames(){
//
//        List<HangmanGame> toReturn = new ArrayList<>();
//
//        for( HangmanGame toCheck : allGames ){
//            String word = toCheck.getHiddenWord().toLowerCase();
//            if( word.charAt(0) == 'a' ||
//                    word.charAt(0) == 'e' ||
//                    word.charAt(0) == 'i' ||
//                    word.charAt(0) == 'o' ||
//                    word.charAt(0) == 'u'){
//                toReturn.add( toCheck );
//            }
//        }
//
//        return toReturn;
//    }
}
