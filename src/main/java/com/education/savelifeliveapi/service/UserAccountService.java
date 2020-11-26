package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.model.Pet;
import com.education.savelifeliveapi.repository.PetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountService {
    
    private final PetRepo petRepo;

    public Pet addPet(Pet pet){
        return petRepo.save(pet);
    }



}
