package com.MyBudgetBackend.service;

public interface SessionService {
    public void loginUser(String email, String password);
    public void logoutUser();
}
