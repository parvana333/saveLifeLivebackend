package com.education.savelifeliveapi.service;

import com.education.savelifeliveapi.model.Blog;
import com.education.savelifeliveapi.repository.BlogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepo blogRepo;

    public Blog addBlog(Blog blog){
        return blogRepo.save(blog);
    }
    public List<Blog> getAllBlog(){
        return blogRepo.findAll();
    }


}
