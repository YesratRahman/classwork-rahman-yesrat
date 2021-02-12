package com.tp.UserMoneyManager.controllers;

import com.tp.UserMoneyManager.exceptions.InvalidExpenseException;
import com.tp.UserMoneyManager.exceptions.InvalidExpenseIdException;
import com.tp.UserMoneyManager.models.Expense;
import com.tp.UserMoneyManager.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpenseController {
    @Autowired
    ExpenseService service;

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

    @GetMapping("/expense/amount/{expenseAmount}")
    public ResponseEntity getExpenseByAmount(@PathVariable Double expenseAmount) {
        try{
            return ResponseEntity.ok(service.getExpenseByAmount(expenseAmount));
        }catch(InvalidExpenseException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/expense/date/{spentDate}")
    public ResponseEntity getExpenseByDate(@PathVariable Date spentDate) {
        try{
            return ResponseEntity.ok(service.getExpenseByDate(spentDate));
        }catch(InvalidExpenseException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/expense/update/{expenseId}")
    public ResponseEntity updateExpense(@PathVariable Integer expenseId, @RequestBody Expense expense){
        try {
            return ResponseEntity.ok(service.updateExpense(expenseId, expense));
        } catch (InvalidExpenseIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/expense/delete/{expenseId}")
    public String deleteExpense(@PathVariable Integer expenseId){
        try{
            service.deleteExpense(expenseId);
            return "Expense with id " + expenseId + " successfully deleted.";
        }catch (InvalidExpenseIdException e){
            return e.getMessage();
        }
    }
}
