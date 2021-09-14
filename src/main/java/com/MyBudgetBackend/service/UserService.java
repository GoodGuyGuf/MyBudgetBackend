package com.MyBudgetBackend.service;

import com.MyBudgetBackend.dto.UserDTO;

public interface UserService {
    public void createUser(UserDTO userDTO);
    public void updateUser(UserDTO userDTO);
    public void deleteUser(Integer userID);
}
