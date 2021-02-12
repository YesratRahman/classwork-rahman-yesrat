package com.tp.UserMoneyManager.controllers;

import com.tp.UserMoneyManager.exceptions.InvalidIncomeException;
import com.tp.UserMoneyManager.exceptions.InvalidIncomeIdException;
import com.tp.UserMoneyManager.models.Income;
import com.tp.UserMoneyManager.services.MoneyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IncomeController {

    @Autowired
    MoneyManagerService service;

    @PostMapping("/income")
    public ResponseEntity addIncome(@RequestBody Income toAdd){
        Income completed = service.addIncome(toAdd);
        return ResponseEntity.ok(completed);
    }

    @GetMapping("/incomes")
    public List<Income> getAllIncomes(){
        return service.getAllIncomes();
    }

    @GetMapping("/income/{incomeId}")
    public ResponseEntity getAllIncomeById(@PathVariable Integer incomeId){
        try{
            return ResponseEntity.ok(service.getAllIncomeById(incomeId));
        }catch(InvalidIncomeIdException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    @GetMapping("/income/amount/{incomeAmount}")
    public ResponseEntity getIncomeByAmount(@PathVariable Double incomeAmount) {
        try{
            return ResponseEntity.ok(service.getIncomeByAmount(incomeAmount));
        }catch(InvalidIncomeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/income/date/{earnedDate}")
    public ResponseEntity getIncomeByDate(@PathVariable Date earnedDate) {
        try{
            return ResponseEntity.ok(service.getIncomeByDate(earnedDate));
        }catch(InvalidIncomeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{incomeId}")
    public ResponseEntity updateIncome(@PathVariable Integer incomeId, @RequestBody Income income){
        try {
            return ResponseEntity.ok(service.updateIncome(incomeId, income));
        } catch (InvalidIncomeIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{incomeId}")
    public String deleteIncome(@PathVariable Integer incomeId){
        try{
            service.deleteIncome(incomeId);
            return "Income with id " + incomeId + " successfully deleted.";
        }catch (InvalidIncomeIdException e){
            return e.getMessage();
        }
    }

}
