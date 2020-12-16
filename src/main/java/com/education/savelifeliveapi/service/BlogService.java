package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.model.Blog;
import com.education.savelifeliveapi.model.User;
import com.education.savelifeliveapi.model.UserAccount;
import com.education.savelifeliveapi.model.VetAccount;
import com.education.savelifeliveapi.repository.BlogRepo;
import com.education.savelifeliveapi.repository.UserAccountRepo;
import com.education.savelifeliveapi.repository.UserRepo;
import com.education.savelifeliveapi.repository.VetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BlogService {

    private final BlogRepo blogRepo;
    private final UserAccountRepo userAccountRepo;
    private final VetRepo vetRepo;


    public Blog addBlog(Blog blog, Long id){
        Optional<UserAccount> userAccountByUserId = userAccountRepo.findByUser_Id(id);
        Optional<VetAccount> vetAccountByUserId = vetRepo.findByUser_Id(id);
        if(userAccountByUserId.isPresent()){
            blog.setUserAccount(userAccountByUserId.get());
        }
        else if(vetAccountByUserId.isPresent()){
            blog.setVetAccount(vetAccountByUserId.get());
        }
        return blogRepo.save(blog);
    }
    public List<Blog> getAllBlog(){
        return blogRepo.findAll();
    }


}
