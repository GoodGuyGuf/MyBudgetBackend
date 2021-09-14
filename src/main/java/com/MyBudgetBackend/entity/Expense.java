package com.MyBudgetBackend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int cost;
	private Date date;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="budget_id")
	private Budget budget;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="expense_id")
    private List<Item> items;

    public int getId() {
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
}
