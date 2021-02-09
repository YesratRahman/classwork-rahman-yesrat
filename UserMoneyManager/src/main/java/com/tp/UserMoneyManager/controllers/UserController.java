package com.tp.UserMoneyManager.controllers;

import com.tp.UserMoneyManager.models.User;
import com.tp.UserMoneyManager.services.MoneyManagerService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    MoneyManagerService service;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody User toAdd){

        User completed = service.addUser(toAdd);
        return ResponseEntity.ok(completed);
    }
}
