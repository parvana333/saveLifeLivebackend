package com.education.savelifeliveapi.repository;

import com.education.savelifeliveapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUserName(String userName);
    Optional<User> findUserByEmailAndUserName(String email, String userName);
}
