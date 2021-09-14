package com.MyBudgetBackend.repository;

import com.MyBudgetBackend.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
