package com.education.savelifeliveapi.repository;

import com.education.savelifeliveapi.model.VetAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepo extends JpaRepository<VetAccount,Long> {
}
