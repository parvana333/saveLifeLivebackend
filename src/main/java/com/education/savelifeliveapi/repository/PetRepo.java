package com.education.savelifeliveapi.repository;

import com.education.savelifeliveapi.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<Pet,Long> {

}
