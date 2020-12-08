package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.exception.AlreadyExistException;
import com.education.savelifeliveapi.model.Appointment;
import com.education.savelifeliveapi.model.Pet;
import com.education.savelifeliveapi.model.UserAccount;
import com.education.savelifeliveapi.repository.AppointmentRepo;
import com.education.savelifeliveapi.repository.PetRepo;
import com.education.savelifeliveapi.repository.UserAccountRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountService {
    
    private final PetRepo petRepo;
    private final AppointmentRepo appointmentRepo;
    private final UserAccountRepo userAccountRepo;

    public Pet addPet(Pet pet){
        return petRepo.save(pet);
    }

    public Appointment requestAppointment(Appointment appointment)  {
        Optional<Appointment> appointmentById = appointmentRepo.findById(appointment.getId());
        if(appointmentById.isPresent()) throw new AlreadyExistException("Appointment already exists");
         return null;
    }
    public UserAccount addUserAccount(UserAccount userAccount){
      return  userAccountRepo.save(userAccount);
    }



}
