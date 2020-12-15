package com.education.savelifeliveapi.repository;

import com.education.savelifeliveapi.dto.UserDto;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.model.VetAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VetRepo extends JpaRepository<VetAccount,Long> {

    Optional<VetAccount> findByUser_Id(Long id);

   @Query(value="select * from  vet_account v where v.first_name= :search or v.country= :search or v.clinic_name= :search",nativeQuery=true)
    List<VetAccount> findVetAccountByCountryOrFirstNameOrClinicName(@Param("search") String searched);



}
