package com.education.savelifeliveapi.repository;

import com.education.savelifeliveapi.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount,Long> {
}
