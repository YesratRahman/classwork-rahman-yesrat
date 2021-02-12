package com.tp.UserMoneyManager.daos.postGresDaos;

import com.tp.UserMoneyManager.daos.Interfaces.ExpenseDao;
import com.tp.UserMoneyManager.daos.mappers.ExpenseMapper;
import com.tp.UserMoneyManager.daos.mappers.IntegerMapper;
import com.tp.UserMoneyManager.exceptions.InvalidExpenseException;
import com.tp.UserMoneyManager.exceptions.InvalidExpenseIdException;
import com.tp.UserMoneyManager.exceptions.InvalidUserIdException;
import com.tp.UserMoneyManager.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component

@Profile({"production", "daoTesting"})
public class ExpensePostgresDao implements ExpenseDao {
    @Autowired
    private JdbcTemplate template;


    @Override
    public Expense addExpense(Expense toAdd) throws InvalidExpenseException, InvalidExpenseIdException, InvalidUserIdException {
        if (toAdd == null) {
            throw new InvalidExpenseException("Expense can not be null");
        }

        List<Integer> expenseId;
        int userCount = template.queryForObject("select count(*) from \"Users\" Where \"userId\" = '" + toAdd.getUserId() + "'", new IntegerMapper("count"));
        if (userCount == 1) {

            expenseId = template.query(
                    "INSERT INTO \"Expenses\" (\"expenseAmount\", \"spentDate\", " +
                            "\"description\", \"userId\") " +
                            "VALUES(?, ?, ?,?) RETURNING \"expenseId\";",
                    new IntegerMapper("expenseId"),
                    toAdd.getExpenseAmount(),
                    toAdd.getSpentDate(),
                    toAdd.getDescription(),
                    toAdd.getUserId());
            if (expenseId.size() == 0) {
                throw new InvalidExpenseIdException("Expense Id not found!");
            }
            toAdd.setExpenseId(expenseId.get(0));

        } else {
            throw new InvalidUserIdException("User Id does not exist");
        }

        return toAdd;
    }

    @Override
    public List<Expense> getAllExpenses() {
        List<Expense> allExpenses = template.query("Select * from \"Expenses\";", new ExpenseMapper());

        if (allExpenses.isEmpty()) {
            return null;
        }
        return allExpenses;
    }

    @Override
    public Expense getAllExpenseById(Integer expenseId) throws InvalidExpenseIdException {
        if (expenseId == null) {
            throw new InvalidExpenseIdException("Expense Id can not be null!");
        }
        Expense getExpense;

        int userCount = template.queryForObject("select count(*) from \"Expenses\" Where \"expenseId\" = '" + expenseId + "'", new IntegerMapper("count"));

        if (userCount == 1) {
            getExpense = template.queryForObject(
                    "SELECT \"expenseId\", \"expenseAmount\",\"spentDate\",\"description\", \"userId\" " +
                            "FROM \"Expenses\" WHERE \"expenseId\" ='" + expenseId + "'", new ExpenseMapper());
        } else {
            throw new InvalidExpenseIdException("Expense id does not exist");
        }
        return getExpense;
    }


    @Override
    public List<Expense> getExpenseByDate(LocalDate date) throws InvalidExpenseException {

        if (date == null) {
            throw new InvalidExpenseException("Spent date can not be null");
        }

        int dateCount = template.queryForObject("select count(*) from \"Expenses\" Where \"spentDate\" = '" + date + "'", new IntegerMapper("count"));

        List<Expense> expenses;
        if (dateCount == 1) {
            expenses = template.query(
                    "select \"expenseId\", \"expenseAmount\", \"description\", \"spentDate\" , \"userId\"" +
                            "from \"Expenses\" " +
                            "where \"spentDate\" = ?;\n",
                    new ExpenseMapper(), date);
        } else {
            throw new InvalidExpenseException("No expense is found for this date");
        }
        return expenses;
    }

    @Override
    public int updateExpense(Integer expenseId, Expense expense) throws InvalidExpenseIdException, InvalidExpenseException, InvalidUserIdException {
        if (expenseId == null) {
            throw new InvalidExpenseIdException("Expense Id can not be null!");
        }
        if (expense == null) {
            throw new InvalidExpenseException("Null expense can not be updated!");
        }

        int updatedExpense;
//        int userCount = template.queryForObject("select count(*) from \"Expenses\" Where \"userId\" = '" + expense.getUserId() + "'", new IntegerMapper("count"));
//
//        if (userCount == 1) {
            updatedExpense = template.update("Update \"Expenses\" " +
                            "Set \"expenseAmount\"= '" + expense.getExpenseAmount() + "', \"spentDate\"= '" + expense.getSpentDate() + "', \"description\"= '" + expense.getDescription() + "' " +
                            "Where \"expenseId\" = '" + expenseId + "'\n");
//        }
//        else {
//            throw new InvalidUserIdException("The user whose expense tried to be updated, doesn't exist.");
//        }

//        updatedExpense = template.update(
//                "Update \"Expenses\" Set \"expenseAmount\"=?, \"spentDate\"='2021-01-02', \"description\"='Gift' Where \"expenseId\" = 1\n")
        return updatedExpense;
    }

        @Override
        public int deleteExpense () {
            return 0;
        }

        //    @Override
        //    public List<Expense> getExpenseByAmount() {
        //        return null;
        //    }
    }
