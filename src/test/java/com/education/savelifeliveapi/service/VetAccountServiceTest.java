package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.dto.UserDto;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.model.VetAccount;
import com.education.savelifeliveapi.repository.UserAccountRepo;
import com.education.savelifeliveapi.repository.UserRepo;
import com.education.savelifeliveapi.repository.VetRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class VetAccountServiceTest {

    @InjectMocks
    private VetAccountService vetAccountService;
    @Mock
    private UserRepo userRepo;
    @Mock
    private VetRepo vetRepo;
    @Mock
    private UserAccountRepo userAccountRepo;
    @Mock
    private User user;
    @Mock
    private VetAccount vetAccount;
    @Mock
    private List<VetAccount> listVet;

    @BeforeEach
    void setup(){
        user=new User();
        user.setId(1L);
        user.setUsername("parvana");
        user.setPassword("202cb962ac59075b964b07152d234b70");
        user.setEmail("parvan@gmail.com");
        user.setPhone("4489525");

        vetAccount=new VetAccount();
        vetAccount.setUser(user);
        vetAccount.setId(1L);
        vetAccount.setFirstName("parvana");
        vetAccount.setFamilyName("yunusova");
        vetAccount.setClinicName("savelife");
        vetAccount.setCountry("azerbaijan");

        listVet.add(vetAccount);

    }
    @Test
    void addVet(){
        given(userRepo.findById(1L)).willReturn(Optional.of(user));
        given(vetAccountService.addVet(vetAccount,1L)).willReturn(vetAccount);
        VetAccount savedVet = vetRepo.save(vetAccount);
        assertEquals(savedVet,vetAccount);
    }
    @Test
    void search(){
        given(vetRepo.findVetAccountByCountryOrFirstNameOrClinicName("parvana"))
                .willReturn(listVet);
        given(vetRepo.findVetAccountByCountryOrFirstNameOrClinicName("azerbaijan"))
                .willReturn(listVet);
        given(vetRepo.findVetAccountByCountryOrFirstNameOrClinicName("savelife"))
                .willReturn(listVet);
        List<VetAccount> foundList = vetAccountService.searchForVet("parvana");
        foundList = vetAccountService.searchForVet("azerbaijan");
        foundList = vetAccountService.searchForVet("savelife");
        assertEquals(foundList,listVet);

    }
}
