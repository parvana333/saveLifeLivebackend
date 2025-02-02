package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.exception.AlreadyExistException;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.model.VetAccount;
import com.education.savelifeliveapi.repository.UserAccountRepo;
import com.education.savelifeliveapi.repository.UserRepo;
import com.education.savelifeliveapi.repository.VetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VetAccountService {
    private final VetRepo vetRepo;
    private final UserRepo userRepo;
    private final UserAccountRepo userAccountRepo;

    public VetAccount addVet(VetAccount vetAccount,Long id){
        if(userAccountRepo.findByUser_Id(id).isPresent()){
            throw new AlreadyExistException("already exist");
        }
        if(vetRepo.findByUser_Id(id).isPresent()){
            throw new AlreadyExistException("already exist");
        }
        Optional<User> userById = userRepo.findById(id);
        if(userById.isPresent()){
            vetAccount.setUser(userById.get());
        }
        return vetRepo.save(vetAccount);

    }

    public List<VetAccount> searchForVet(String searched){
        return vetRepo.findVetAccountByCountryOrFirstNameOrClinicName(searched);
    }

}
