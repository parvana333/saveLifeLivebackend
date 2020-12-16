package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.dto.SearchDto;
import com.education.savelifeliveapi.model.VetAccount;
import com.education.savelifeliveapi.service.VetAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetApi")
@RequiredArgsConstructor
@Slf4j
public class VetAccountController {
    private final VetAccountService vetAccountService;

    @PostMapping("/addVet/{id}")
    public ResponseEntity<VetAccount> addVet(@RequestBody VetAccount vet,@PathVariable Long id){
        return ResponseEntity.ok(vetAccountService.addVet(vet,id));

    }
    @PostMapping("/searchVet")
    public ResponseEntity<List<VetAccount>> findVet(@RequestBody SearchDto searchDto){
        log.info("name={}",searchDto.getName());
        return ResponseEntity.ok(vetAccountService.searchForVet(searchDto.getName()));
    }



}
