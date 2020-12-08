package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.model.VetAccount;
import com.education.savelifeliveapi.service.VetAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vetApi")
@RequiredArgsConstructor
public class VetAccountController {
    private final VetAccountService vetAccountService;

    public ResponseEntity<VetAccount> addVet(@RequestBody VetAccount vet){
        return ResponseEntity.ok(vetAccountService.addVet(vet));

    }



}
