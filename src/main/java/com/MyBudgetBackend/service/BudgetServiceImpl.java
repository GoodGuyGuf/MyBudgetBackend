package com.MyBudgetBackend.service;

import com.MyBudgetBackend.dto.BudgetDTO;
import com.MyBudgetBackend.entity.Budget;
import com.MyBudgetBackend.entity.User;
import com.MyBudgetBackend.repository.BudgetRepository;
import com.MyBudgetBackend.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

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
        Optional<User> user = userRepository.findById(budgetDTO.getUserDTO().getId());
        if(user.isPresent()) {
            budgetDTO.setUserDTO(User.convertUserToUserDTO(user.get()));
            Budget budget = BudgetDTO.convertToBudget(budgetDTO);
            budgetRepository.save(budget);
        }
    }

    @Override
    public void updateBudget(BudgetDTO budgetDTO) {
        Optional<Budget> budget = budgetRepository.findById(budgetDTO.getId());
        if (budget.isPresent()) {
            Budget newBudget = budget.get();
            newBudget.setName(budgetDTO.getName());
            newBudget.setAmount(budgetDTO.getAmount());
            budgetRepository.save(newBudget);
        }
    }

    @Override
    public void deleteBudget(Integer budgetID) {
        Optional<Budget> budget = budgetRepository.findById(budgetID);
        if(budget.isPresent()) {
            budgetRepository.deleteById(budgetID);
        }
    }
}
