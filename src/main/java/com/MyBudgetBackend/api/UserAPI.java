package com.MyBudgetBackend.api;

import com.MyBudgetBackend.dto.UserDTO;
import com.MyBudgetBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserAPI {

    @Autowired
    UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return new ResponseEntity<>("CREATE: SUCCESS", HttpStatus.CREATED);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return new ResponseEntity<>("UPDATE: SUCCESS", HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> deleteUser(@RequestBody UserDTO userDTO) {
        userService.deleteUser(userDTO.getId());
        return new ResponseEntity<>("DELETE: SUCCESS", HttpStatus.OK);
    }
}
