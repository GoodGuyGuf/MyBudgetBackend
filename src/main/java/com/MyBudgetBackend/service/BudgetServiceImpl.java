package com.MyBudgetBackend.service;

import com.MyBudgetBackend.dto.BudgetDTO;
import com.MyBudgetBackend.entity.Budget;
import com.MyBudgetBackend.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "budgetService")
@Transactional
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    BudgetRepository budgetRepository;

    @Override
    public List<BudgetDTO> getAllBudgets() {
        Iterable<Budget> iterableBudgets = budgetRepository.findAll();
        List<Budget> budgets = new ArrayList<>();
        iterableBudgets.forEach(budgets::add);
        List<BudgetDTO> budgetDTOs = Budget.convertBudgetsToBudgetDTOs(budgets);
        return budgetDTOs;
    }

    @Override
    public void createBudget(BudgetDTO budgetDTO) {
        Budget budget = BudgetDTO.convertToBudget(budgetDTO);
        budgetRepository.save(budget);
    }

    @Override
    public void updateBudget(BudgetDTO budgetDTO) {
        Optional<Budget> optionalBudget = budgetRepository.findById(budgetDTO.getId());
        Budget budget = optionalBudget.get();
        budget.setName(budgetDTO.getName());
        budget.setAmount(budgetDTO.getAmount());
        budgetRepository.save(budget);
    }

    @Override
    public void deleteBudget(Integer budgetID) {
        Optional<Budget> optionalBudget = budgetRepository.findById(budgetID);
        optionalBudget.orElseThrow();
        budgetRepository.deleteById(budgetID);
    }
}
