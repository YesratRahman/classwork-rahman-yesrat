package com.tp.diceroller.controllers;

import com.tp.diceroller.services.RNG;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {
    //First controller
    //Speak to the outside world

    //The most common use of rest is GET request
    //When a browser goes to a URL you are creating a GET :o

    //Handler for our GET request:

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/sixsides")
    public int sixSides(){
        return RNG.rollDice(6);
    }

    @GetMapping("/twentysides")
    public int twentySides(){
        return RNG.rollDice(20);
    }
    @GetMapping("/nsides")
    public int nSides(Integer num){
        return RNG.rollDice(num);
    }

    @GetMapping("/nsides/{num}")
    public int nSizesPathVariable(@PathVariable Integer num){
        return RNG.rollDice(num);

    }
}
