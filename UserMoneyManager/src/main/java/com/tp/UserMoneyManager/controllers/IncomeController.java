package com.tp.UserMoneyManager.controllers;

import com.tp.UserMoneyManager.exceptions.InvalidExpenseIdException;
import com.tp.UserMoneyManager.models.Expense;
import com.tp.UserMoneyManager.services.MoneyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class IncomeController {

    @Autowired
    MoneyManagerService service;

    @PostMapping("/expense")
    public ResponseEntity addExpense(@RequestBody Expense toAdd){
        Expense completed = service.addExpense(toAdd);
        return ResponseEntity.ok(completed);
    }

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return service.getAllExpenses();
    }

    @GetMapping("/expense/{expenseId}")
    public ResponseEntity getAllExpenseById(@PathVariable Integer expenseId){
        try{
            return ResponseEntity.ok(service.getAllExpenseById(expenseId));
        }catch(InvalidExpenseIdException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
