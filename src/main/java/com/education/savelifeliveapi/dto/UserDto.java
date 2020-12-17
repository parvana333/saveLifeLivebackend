package com.education.savelifeliveapi.dto;

import com.education.savelifeliveapi.model.UserAccount;
import com.education.savelifeliveapi.model.VetAccount;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String type;
    private VetAccount vetAccount;
    private UserAccount userAccount;
}
