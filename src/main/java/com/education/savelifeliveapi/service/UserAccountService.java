package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.exception.AlreadyExistException;
import com.education.savelifeliveapi.exception.NoPetException;
import com.education.savelifeliveapi.model.Appointment;
import com.education.savelifeliveapi.model.Pet;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.model.UserAccount;
import com.education.savelifeliveapi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountService {
    
    private final PetRepo petRepo;
    private final AppointmentRepo appointmentRepo;
    private final UserAccountRepo userAccountRepo;
    private final UserRepo userRepo;
    private final VetRepo vetRepo;

    public Pet addPet(Pet pet, Long id){
        Optional<UserAccount> userAccountByUserId = userAccountRepo.findByUser_Id(id);
        if(userAccountByUserId.isPresent()){
            pet.setUserAccount(userAccountByUserId.get());
        }
        return petRepo.save(pet);
    }
    public List<Pet> getMyPets(Long id){
        Optional<UserAccount> userAccountByUserId = userAccountRepo.findByUser_Id(id);
        if(userAccountByUserId.isPresent()){
            return userAccountByUserId.get().getPet();
        }
        throw new NoPetException("user does not have pet");


    }

    public Appointment requestAppointment(Appointment appointment)  {
        Optional<Appointment> appointmentById = appointmentRepo.findById(appointment.getId());
        if(appointmentById.isPresent()) throw new AlreadyExistException("Appointment already exists");
         return null;
    }

    public UserAccount addUserAccount(UserAccount userAccount,Long id){
        if(vetRepo.findByUser_Id(id).isPresent()){
            throw new AlreadyExistException("already exist");
        }
        if(userAccountRepo.findByUser_Id(id).isPresent()){
            throw new AlreadyExistException("already exist");
        }
        Optional<User> userById = userRepo.findById(id);
        if(userById.isPresent()){
            userAccount.setUser(userById.get());
        }
        return userAccountRepo.save(userAccount);

    }



}
