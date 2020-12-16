package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.dto.UserDto;
import com.education.savelifeliveapi.exception.AlreadyExistException;
import com.education.savelifeliveapi.exception.EmailExistException;
import com.education.savelifeliveapi.exception.UserNameExistException;
import com.education.savelifeliveapi.exception.UserNotFoundException;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.model.VetAccount;
import com.education.savelifeliveapi.repository.UserAccountRepo;
import com.education.savelifeliveapi.repository.UserRepo;
import com.education.savelifeliveapi.repository.VetRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.DigestUtils;

import java.util.Optional;

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
    @Mock
    private UserDto userDto;
    @Mock
    private User userBack;
    @Mock
    private VetAccount vetAccount;


    @BeforeEach
    void setup(){
        user=new User();
        user.setId(1l);
        user.setUsername("parvana");
        user.setPassword("123");
        user.setEmail("parvan@gmail.com");
        user.setPhone("4489525");

        userBack=new User();
        userBack.setId(1l);
        userBack.setUsername("parvana");
        userBack.setPassword("7363a0d0604902af7b70b271a0b96480");
        userBack.setEmail("parvan@gmail.com");
        userBack.setPhone("4489525");

        userDto=new UserDto();
        userDto.setUsername("parvana");
        userDto.setEmail("parvan@gmail.com");
        userDto.setType("Vet");

        vetAccount=new VetAccount();
        vetAccount.setUser(user);
        vetAccount.setId(1L);
    }


    @Test
    void registerTest(){
        given(userService.register(user)).willReturn(user);
        User savedUser=userRepo.save(user);
        assertEquals(savedUser,user);
    }

    @Test
    void loginTest(){
        given(userRepo.findUserByUsername(user.getUsername())).willReturn(Optional.of(userBack));
        UserDto userDtoAnswer=userService.login(user);
        given(userService.login(user)).willReturn(userDto);
        given(vetRepo.findByUser_Id(user.getId())).willReturn(Optional.of(vetAccount));
        assertEquals(userDtoAnswer,userDto);
    }








}
