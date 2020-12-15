package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.dto.UserDto;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j

public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping(value = "/login" )
    public UserDto login(@RequestBody User user){
        log.info("username={} password={}",user.getUsername(),user.getPassword());
        return userService.login(user);

    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }

}
