package com.MyBudgetBackend.repository;

import com.MyBudgetBackend.entity.Budget;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget, Integer> {

}
