package com.MyBudgetBackend.service;

import com.MyBudgetBackend.dto.ItemDTO;

public interface ItemService {
    public void createItem(ItemDTO itemDTO);
    public void updateItem(ItemDTO itemDTO);
    public void deleteItem(Integer itemID);
}
