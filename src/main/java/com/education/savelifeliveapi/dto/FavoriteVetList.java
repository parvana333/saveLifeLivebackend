package com.education.savelifeliveapi.dto;

import com.education.savelifeliveapi.model.UserAccount;
import com.education.savelifeliveapi.model.VetAccount;
import lombok.Data;

import java.util.List;

@Data
public class FavoriteVetList {
    private UserAccount userAccount;
    private List<VetAccount> listOfVet;

}
