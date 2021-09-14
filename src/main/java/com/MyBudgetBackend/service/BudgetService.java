package com.MyBudgetBackend.service;

import com.MyBudgetBackend.dto.BudgetDTO;
import java.util.List;

public interface BudgetService {
    public List<BudgetDTO> getAllBudgets();
    public void createBudget(BudgetDTO budgetDTO);
    public void updateBudget(BudgetDTO budgetDTO);
    public void deleteBudget(Integer budgetID);
}
