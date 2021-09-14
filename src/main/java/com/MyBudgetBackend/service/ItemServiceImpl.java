package com.MyBudgetBackend.service;

import com.MyBudgetBackend.dto.ItemDTO;
import com.MyBudgetBackend.entity.Item;
import com.MyBudgetBackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service(value = "itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void createItem(ItemDTO itemDTO) {
        Item item = ItemDTO.convertToItem(itemDTO);
        itemRepository.save(item);
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        Optional<Item> optionalItem = itemRepository.findById(itemDTO.getId());
        Item item = optionalItem.get();
        item.setName(itemDTO.getName());
        item.setCost(itemDTO.getCost());
        item.setDate(itemDTO.getDate());
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Integer itemID) {
        Optional<Item> optionalItem = itemRepository.findById(itemID);
        optionalItem.orElseThrow();
        itemRepository.deleteById(itemID);
    }
}
