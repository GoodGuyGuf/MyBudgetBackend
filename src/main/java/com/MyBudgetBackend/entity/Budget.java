package com.MyBudgetBackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private int amount;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
	private User user;

	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="budget_id")
    private List<Expense> expenses;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
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
        Budget otherBudget = (Budget) obj;
        if (this.getId() == null)
            if (otherBudget.getId() != null)
                return false;
            else if (this.getId().equals(otherBudget.getId()))
                return false;
        return true;
    }
}
