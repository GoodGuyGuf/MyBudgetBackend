package com.MyBudgetBackend.repository;

import com.MyBudgetBackend.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
