package com.MyBudgetBackend.api;

import com.MyBudgetBackend.dto.ItemDTO;
import com.MyBudgetBackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ItemAPI {

    @Autowired
    ItemService itemService;

    @PostMapping(value = "/items")
    public ResponseEntity<String> createItem(@RequestBody ItemDTO itemDTO) {
        itemService.createItem(itemDTO);
        return new ResponseEntity<>("CREATE: SUCCESS", HttpStatus.CREATED);
    }

    @PutMapping(value = "/items/{id}")
    public ResponseEntity<String> updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(itemDTO);
        return new ResponseEntity<>("UPDATE: SUCCESS", HttpStatus.OK);
    }

    @DeleteMapping(value = "/items/{id}")
    public ResponseEntity<String> deleteItem(@RequestBody ItemDTO itemDTO) {
        itemService.deleteItem(itemDTO.getId());
        return new ResponseEntity<>("DELETE: SUCCESS", HttpStatus.OK);
    }
}
