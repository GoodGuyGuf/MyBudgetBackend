package com.MyBudgetBackend.entity;

import com.MyBudgetBackend.dto.ExpenseDTO;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private int cost;
	private Date date;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="budget_id")
	private Budget budget;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="expense_id")
    private List<Item> items;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
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

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static ExpenseDTO convertExpenseToExpenseDTO(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setId(expense.getId());
        expenseDTO.setName(expense.getName());
        expenseDTO.setCost(expense.getCost());
        expenseDTO.setDate(expense.getDate());
        expenseDTO.setBudgetDTO(Budget.convertBudgetToBudgetDTO(expense.getBudget()));
        expenseDTO.setItemDTOs(Item.convertItemsToItemDTOs(expense.getItems()));
        return expenseDTO;
    }

    public static List<ExpenseDTO> convertExpensesToExpenseDTOs(List<Expense> expenses) {
        List<ExpenseDTO> expenseDTOs = new ArrayList<>();
        expenses.forEach(expense -> {
            expenseDTOs.add(Expense.convertExpenseToExpenseDTO(expense));
        });
        return expenseDTOs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Expense otherExpense = (Expense) obj;
        if (this.getId() == null)
            if (otherExpense.getId() != null)
                return false;
            else if (this.getId().equals(otherExpense.getId()))
                return false;
        return true;
    }
}
