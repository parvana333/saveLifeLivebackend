package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.model.Pet;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.model.UserAccount;
import com.education.savelifeliveapi.repository.PetRepo;
import com.education.savelifeliveapi.repository.UserAccountRepo;
import com.education.savelifeliveapi.repository.UserRepo;
import com.education.savelifeliveapi.repository.VetRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserAccountServiceTest {

    @InjectMocks
    private UserAccountService userAccountService;
    @Mock
    private UserRepo userRepo;
    @Mock
    private VetRepo vetRepo;
    @Mock
    private UserAccountRepo userAccountRepo;
    @Mock
    private User user;
    @Mock
    private UserAccount userAccount;
    @Mock
    private Pet pet;
    @Mock
    private PetRepo petRepo;

    @BeforeEach
    void setup() {
        user = new User();
        user.setId(1L);
        user.setUsername("parvana");
        user.setPassword("202cb962ac59075b964b07152d234b70");
        user.setEmail("parvan@gmail.com");
        user.setPhone("4489525");

        userAccount = new UserAccount();
        userAccount.setUser(user);
        userAccount.setId(1L);
        userAccount.setFirstName("parvana");
        userAccount.setFamilyName("yunusova");
        userAccount.setCountry("azerbaijan");
        userAccount.setGender("female");

        pet = new Pet();
        pet.setId(1L);
        pet.setBreed("dog");
        pet.setName("mosi");
        pet.setUserAccount(userAccount);
    }

    @Test
    void addOwner() {
        given(userRepo.findById(1L)).willReturn(Optional.of(user));
        given(userAccountService.addUserAccount(userAccount, 1L)).willReturn(userAccount);
        UserAccount savedUser = userAccountRepo.save(userAccount);
        assertEquals(savedUser, userAccount);
    }

    @Test
    void addPet() {
        given(userAccountRepo.findByUser_Id(1L)).willReturn(Optional.of(userAccount));
        given(userAccountService.addPet(pet, 1l)).willReturn(pet);
        Pet savedPet = petRepo.save(pet);
        assertEquals(savedPet, pet);

    }
}
