package com.MyBudgetBackend.dto;

import com.MyBudgetBackend.entity.Budget;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class BudgetDTO {
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private int amount;

    @Valid
    private UserDTO userDTO;

    private List<ExpenseDTO> expenseDTOs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<ExpenseDTO> getExpenseDTOs() {
        return expenseDTOs;
    }

    public void setExpenseDTOs(List<ExpenseDTO> expenseDTOs) {
        this.expenseDTOs = expenseDTOs;
    }

    public static Budget convertToBudget(BudgetDTO budgetDTO) {
        Budget budget = new Budget();
        budget.setId(budgetDTO.getId());
        budget.setName(budgetDTO.getName());
        budget.setAmount(budgetDTO.getAmount());
        budget.setUser(UserDTO.convertToUser(budgetDTO.getUserDTO()));
        return budget;
    }

    public static List<Budget> convertBudgetDTOsToBudgets(List<BudgetDTO> budgetDTOs) {
        List<Budget> budgets = new ArrayList<>();
        budgetDTOs.forEach(budgetDTO -> {
            budgets.add(BudgetDTO.convertToBudget(budgetDTO));
        });
        return budgets;
    }
}
