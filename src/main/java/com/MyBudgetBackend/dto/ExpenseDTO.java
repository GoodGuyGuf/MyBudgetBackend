package com.MyBudgetBackend.dto;

import com.MyBudgetBackend.entity.Expense;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDTO {
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private int cost;

    @NotNull
    private Date date;

    @Valid
    private BudgetDTO budgetDTO;

    private List<ItemDTO> itemDTOs;

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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BudgetDTO getBudgetDTO() {
        return budgetDTO;
    }

    public void setBudgetDTO(BudgetDTO budgetDTO) {
        this.budgetDTO = budgetDTO;
    }

    public List<ItemDTO> getItemDTOs() {
        return itemDTOs;
    }

    public void setItemDTOs(List<ItemDTO> itemDTOs) {
        this.itemDTOs = itemDTOs;
    }

    public static Expense convertToExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setId(expenseDTO.getId());
        expense.setName(expenseDTO.getName());
        expense.setCost(expenseDTO.getCost());
        expense.setDate(expenseDTO.getDate());
        return expense;
    }

    public static List<Expense> convertExpenseDTOsToExpense(List<ExpenseDTO> expenseDTOs) {
        List<Expense> expenses = new ArrayList<>();
        expenseDTOs.forEach(expenseDTO -> {
            expenses.add(ExpenseDTO.convertToExpense(expenseDTO));
        });
        return expenses;
    }
}
