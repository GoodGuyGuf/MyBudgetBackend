package com.MyBudgetBackend.service;

import com.MyBudgetBackend.dto.ExpenseDTO;

public interface ExpenseService {
    public void createExpense(ExpenseDTO expenseDTO);
    public void updateExpense(ExpenseDTO expenseDTO);
    public void deleteExpense(Integer expenseID);
}
