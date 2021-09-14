package com.MyBudgetBackend.dto;

import com.MyBudgetBackend.entity.User;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public class UserDTO {
    private Integer id;

    @NotNull(message = "{user.name.absent}")
    private String name;

    @Email(message = "{user.email.invalid}")
    @NotNull(message = "{user.email.absent}")
    private String email;

    @NotNull(message = "{user.password.absent}")
    private String password;

    private List<BudgetDTO> budgetDTOs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BudgetDTO> getBudgetDTOs() {
        return budgetDTOs;
    }

    public void setBudgetDTOs(List<BudgetDTO> budgetDTOs) {
        this.budgetDTOs = budgetDTOs;
    }

    public static User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
