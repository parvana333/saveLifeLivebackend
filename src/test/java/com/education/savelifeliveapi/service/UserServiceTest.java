package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.exception.AlreadyExistException;
import com.education.savelifeliveapi.exception.EmailExistException;
import com.education.savelifeliveapi.exception.UserNameExistException;
import com.education.savelifeliveapi.exception.UserNotFoundException;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.repository.UserAccountRepo;
import com.education.savelifeliveapi.repository.UserRepo;
import com.education.savelifeliveapi.repository.VetRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepo userRepo;
    @Mock
    private VetRepo vetRepo;
    @Mock
    private UserAccountRepo userAccountRepo;
    @Mock
    private User user;

    @BeforeEach
    void setup(){
        user=new User();
        user.setId(1l);
        user.setUsername("parvana");
        user.setPassword("123");
        user.setEmail("parvan@gmail.com");
        user.setPhone("4489525");
    }


    @Test
    void registerTest(){
        given(userService.register(user)).willReturn(user);
        User savedUser=userRepo.save(user);
        assertEquals(savedUser,user);
    }


    void loginTest(){

    }








}
