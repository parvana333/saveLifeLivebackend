package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.dto.UserDto;
import com.education.savelifeliveapi.exception.AlreadyExistException;
import com.education.savelifeliveapi.exception.EmailExistException;
import com.education.savelifeliveapi.exception.UserNameExistException;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepo userRepo;

    public User register(User user) {
        log.info("userName={} email={}  phone={}", user.getUserName(), user.getEmail(), user.getPhone());
        if (userRepo.findUserByUserName(user.getUserName()).isPresent()) {
            throw new UserNameExistException("this UserName is already in use");
        } else if (userRepo.findUserByEmail(user.getEmail()).isPresent()) {
            throw new EmailExistException("this email is already in use");
        } else if (userRepo.findUserByEmailAndUserName(user.getUserName(), user.getEmail()).isPresent()) {
            throw new AlreadyExistException("Already exists");
        } else {
            String md5Pass= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5Pass);
            return userRepo.save(user);
        }
    }

    public Boolean login(UserDto userDto){
        Optional<User> userByUserName = userRepo.findUserByUserName(userDto.getUserName());
        if(userByUserName.isPresent()){
            String md5Pass= DigestUtils.md5DigestAsHex(userDto.getPassword().getBytes());
            if(userByUserName.get().getPassword().equals(md5Pass)) return true;
        }
        return false;
    }

}
