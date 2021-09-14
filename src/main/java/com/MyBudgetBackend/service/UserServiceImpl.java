package com.MyBudgetBackend.service;

import com.MyBudgetBackend.dto.UserDTO;
import com.MyBudgetBackend.entity.User;
import com.MyBudgetBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(UserDTO userDTO) {
        User user = UserDTO.convertToUser(userDTO);
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(userDTO.getId());
        User user = optionalUser.get();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userID) {
        Optional<User> optionalUser = userRepository.findById(userID);
        optionalUser.orElseThrow();
        userRepository.deleteById(userID);
    }
}
