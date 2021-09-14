package com.MyBudgetBackend.repository;

import com.MyBudgetBackend.entity.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Integer> {

}
