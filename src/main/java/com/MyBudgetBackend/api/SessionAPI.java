package com.MyBudgetBackend.api;

import com.MyBudgetBackend.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SessionAPI {

    @Autowired
    SessionService sessionService;

    @PostMapping(value = "/login")
    public ResponseEntity<String> loginUser(String email, String password) {
        sessionService.loginUser(email, password);
        return new ResponseEntity<>("LOGIN: SUCCESS", HttpStatus.OK);
    }

    @DeleteMapping(value = "/logout")
    public ResponseEntity<String> logoutUser() {
        sessionService.logoutUser();
        return new ResponseEntity<>("LOGOUT: SUCCESS", HttpStatus.OK);
    }
}
