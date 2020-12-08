package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.model.VetAccount;
import com.education.savelifeliveapi.repository.VetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VetAccountService {
    private final VetRepo vetRepo;

    public VetAccount addVet(VetAccount vetAccount){
      return vetRepo.save(vetAccount);

    }

}
