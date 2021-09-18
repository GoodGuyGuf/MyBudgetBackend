package com.MyBudgetBackend.api;

import com.MyBudgetBackend.dto.BudgetDTO;
import com.MyBudgetBackend.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BudgetAPI {

    @Autowired
    BudgetService budgetService;

    @GetMapping(value = "/budgets")
    public ResponseEntity<List<BudgetDTO>> getAllBudgets() {
        List<BudgetDTO> budgetDTOs = budgetService.getAllBudgets();
        return new ResponseEntity<>(budgetDTOs, HttpStatus.OK);
    }

    @PostMapping(value = "/budgets")
    public ResponseEntity<String> createBudget(@RequestBody BudgetDTO budgetDTO) {
        budgetService.createBudget(budgetDTO);
        return new ResponseEntity<>("CREATE BUDGET: SUCCESS", HttpStatus.CREATED);
    }

    @PutMapping(value = "/budgets/{id}")
    public ResponseEntity<String> updateBudget(@RequestBody BudgetDTO budgetDTO) {
        budgetService.updateBudget(budgetDTO);
        return new ResponseEntity<>("UPDATE BUDGET: SUCCESS", HttpStatus.OK);
    }


    @DeleteMapping(value = "/budgets/{id}")
    public ResponseEntity<String> deleteBudget(@RequestBody BudgetDTO budgetDTO) {
        budgetService.deleteBudget(budgetDTO.getId());
        return new ResponseEntity<>("DELETE BUDGET: SUCCESS", HttpStatus.OK);
    }
}
