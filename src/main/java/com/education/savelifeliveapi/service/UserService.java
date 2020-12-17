package com.education.savelifeliveapi.service;
import com.education.savelifeliveapi.dto.UserDto;
import com.education.savelifeliveapi.exception.AlreadyExistException;
import com.education.savelifeliveapi.exception.EmailExistException;
import com.education.savelifeliveapi.exception.UserNameExistException;
import com.education.savelifeliveapi.exception.UserNotFoundException;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.model.UserAccount;
import com.education.savelifeliveapi.repository.UserAccountRepo;
import com.education.savelifeliveapi.repository.UserRepo;
import com.education.savelifeliveapi.repository.VetRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {
    private final UserRepo userRepo;
    private final VetRepo vetRepo;
    private final UserAccountRepo userAccountRepo;

    public User register(User user) {
        log.info("userName={} email={}  phone={}", user.getUsername(), user.getEmail(), user.getPhone());
        if(user.getUsername()==null || user.getEmail()==null || user.getPassword()==null ){
            throw new HttpMessageNotReadableException("No proper json format");
        }
        if (userRepo.findUserByUsername(user.getUsername()).isPresent()) {
            throw new UserNameExistException("this UserName is already in use");
        } else if (userRepo.findUserByEmail(user.getEmail()).isPresent()) {
            throw new EmailExistException("this email is already in use");
        } else if (userRepo.findUserByEmailAndUsername(user.getUsername(), user.getEmail()).isPresent()) {
            throw new AlreadyExistException("Already exists");
        } else {
            String md5Pass= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5Pass);
            return userRepo.save(user);
        }
    }

    public UserDto login(User user){
        Optional<User> userByUserName = userRepo.findUserByUsername(user.getUsername());
        if(userByUserName.isPresent()){
            UserDto userDto=new UserDto();
            String md5Pass= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            if(userByUserName.get().getPassword().equals(md5Pass)) {
                if(vetRepo.findByUser_Id(userByUserName.get().getId()).isPresent()){
                    userDto.setType("Vet");
                    userDto.setVetAccount(vetRepo.findByUser_Id(userByUserName.get().getId()).get());
                }
                if(userAccountRepo.findByUser_Id(userByUserName.get().getId()).isPresent()){
                    userDto.setType("Owner");
                    userDto.setUserAccount(userAccountRepo.findByUser_Id(userByUserName.get().getId()).get());
                }
                userDto.setId(userByUserName.get().getId());
                userDto.setUsername(user.getUsername());
                userDto.setEmail(userByUserName.get().getEmail());
                return userDto;
            }
        }
        throw new UserNotFoundException("User has not registred");
    }
    public User updatePass(String name,Long id){
        Optional<User> userbyId = userRepo.findById(id);
        if(userbyId.isPresent()){
            String md5 = DigestUtils.md5DigestAsHex(name.getBytes());
            userbyId.get().setPassword(md5);
        }
        return userRepo.save(userbyId.get());
    }
    public User updateEmail(String name,Long id){
        Optional<User> userbyId = userRepo.findById(id);
        if(userbyId.isPresent()){
            userbyId.get().setEmail(name);
        }
        return userRepo.save(userbyId.get());
    }

}
