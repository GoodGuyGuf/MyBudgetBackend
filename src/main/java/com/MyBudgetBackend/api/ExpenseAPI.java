package com.MyBudgetBackend.api;

import com.MyBudgetBackend.dto.ExpenseDTO;
import com.MyBudgetBackend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ExpenseAPI {

    @Autowired
    ExpenseService expenseService;

    @PostMapping(value = "/expenses")
    public ResponseEntity<String> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        expenseService.createExpense(expenseDTO);
        return new ResponseEntity<>("CREATE: SUCCESS", HttpStatus.CREATED);
    }

    @PutMapping(value = "/expenses/{id}")
    public ResponseEntity<String> updateExpense(@RequestBody ExpenseDTO expenseDTO) {
        expenseService.updateExpense(expenseDTO);
        return new ResponseEntity<>("UPDATE: SUCCESS", HttpStatus.OK);
    }

    @DeleteMapping(value = "/expenses/{id}")
    public ResponseEntity<String> deleteExpense(@RequestBody ExpenseDTO expenseDTO) {
        expenseService.deleteExpense(expenseDTO.getId());
        return new ResponseEntity<>("DELETE: SUCCESS", HttpStatus.OK);
    }

}
