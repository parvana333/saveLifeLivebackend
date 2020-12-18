package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.exception.GeneralException;
import com.education.savelifeliveapi.model.Appointment;
import com.education.savelifeliveapi.model.Pet;
import com.education.savelifeliveapi.model.UserAccount;
import com.education.savelifeliveapi.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userApi")
@RequiredArgsConstructor
@Slf4j
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping("addPet/{id}")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet,@PathVariable Long id ){
        log.info("name={} breed={} id={}",pet.getName(),pet.getBreed(),id);
        return ResponseEntity.ok(userAccountService.addPet(pet,id));
    }

    @PostMapping("addOwner/{id}")
    public ResponseEntity<UserAccount> addUserAccount(@RequestBody UserAccount userAccount, @PathVariable Long id){
        return ResponseEntity.ok(userAccountService.addUserAccount(userAccount,id));
    }

    @GetMapping("/myPets/{id}")
    public ResponseEntity<List<Pet>> getAllPet(@PathVariable Long id){
        return ResponseEntity.ok(userAccountService.getMyPets(id));

    }
    @PostMapping("/appoinment/{userId}/{vetId}")
    public ResponseEntity<Appointment> saveAppoinment(@RequestBody Appointment appointment,@PathVariable Long userId,@PathVariable Long vetId){
        return ResponseEntity.ok(userAccountService.requestAppointment(appointment,userId,vetId));

    }


}
