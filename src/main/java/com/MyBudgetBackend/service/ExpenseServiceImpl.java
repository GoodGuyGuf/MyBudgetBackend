package com.MyBudgetBackend.service;

import com.MyBudgetBackend.dto.ExpenseDTO;
import com.MyBudgetBackend.entity.Expense;
import com.MyBudgetBackend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service(value = "expenseService")
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public void createExpense(ExpenseDTO expenseDTO) {
        Expense expense = ExpenseDTO.convertToExpense(expenseDTO);
        expenseRepository.save(expense);
    }

    @Override
    public void updateExpense(ExpenseDTO expenseDTO) {
        Optional<Expense> optionalExpense = expenseRepository.findById(expenseDTO.getId());
        Expense expense = optionalExpense.get();
        expense.setName(expenseDTO.getName());
        expense.setCost(expenseDTO.getCost());
        expense.setDate(expenseDTO.getDate());
        expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Integer expenseID) {
        Optional optionalExpense = expenseRepository.findById(expenseID);
        optionalExpense.orElseThrow();
        expenseRepository.deleteById(expenseID);
    }
}
