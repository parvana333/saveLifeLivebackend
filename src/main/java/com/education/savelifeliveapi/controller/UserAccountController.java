package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.model.Pet;
import com.education.savelifeliveapi.model.UserAccount;
import com.education.savelifeliveapi.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("userApi")
@RequiredArgsConstructor
public class UserAccountController {
    private final UserAccountService userAccountService;

    @PostMapping("addPet")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet){
        Pet savedPet = userAccountService.addPet(pet);
        return ResponseEntity.ok(savedPet);
    }

    @PostMapping("addOwner/{id}")
    public ResponseEntity<UserAccount> addUserAccount(@RequestBody UserAccount userAccount, @PathVariable Long id){
        return ResponseEntity.ok(userAccountService.addUserAccount(userAccount,id));
    }


}
