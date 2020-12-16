package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.exception.GeneralException;
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

    @PostMapping("addPet/{id}")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet,@PathVariable Long id ){
        return ResponseEntity.ok(userAccountService.addPet(pet,id));
    }

    @PostMapping("addOwner/{id}")
    public ResponseEntity<UserAccount> addUserAccount(@RequestBody UserAccount userAccount, @PathVariable Long id){
        return ResponseEntity.ok(userAccountService.addUserAccount(userAccount,id));
    }


}
