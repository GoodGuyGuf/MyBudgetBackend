package com.MyBudgetBackend.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private int cost;
	private Date date;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="expense_id")
	private Expense expense;

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

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
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
        Item otherItem = (Item) obj;
        if (this.getId() == null)
            if (otherItem.getId() != null)
                return false;
            else if (this.getId().equals(otherItem.getId()))
                return false;
        return true;
    }
}
