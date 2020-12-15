package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.dto.SearchDto;
import com.education.savelifeliveapi.model.VetAccount;
import com.education.savelifeliveapi.service.VetAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetApi")
@RequiredArgsConstructor
public class VetAccountController {
    private final VetAccountService vetAccountService;

    @PostMapping("/addVet/{id}")
    public ResponseEntity<VetAccount> addVet(@RequestBody VetAccount vet,@PathVariable Long id){
        return ResponseEntity.ok(vetAccountService.addVet(vet,id));

    }
    @GetMapping("/searchVet")
    public ResponseEntity<List<VetAccount>> findVet(@RequestBody SearchDto searchDto){
        return ResponseEntity.ok(vetAccountService.searchForVet(searchDto.getName()));
    }



}
