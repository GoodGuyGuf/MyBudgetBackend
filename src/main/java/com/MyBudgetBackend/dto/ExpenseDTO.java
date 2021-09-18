package com.MyBudgetBackend.dto;

import com.MyBudgetBackend.entity.Expense;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDTO {
    private Integer id;
    private String name;
    private int cost;
    private Date date;
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
        expense.setBudget(BudgetDTO.convertToBudget(expenseDTO.getBudgetDTO()));
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
