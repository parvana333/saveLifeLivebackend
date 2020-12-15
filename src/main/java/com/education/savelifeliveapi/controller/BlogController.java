package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.model.Blog;
import com.education.savelifeliveapi.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("blog")
@RequiredArgsConstructor
public class BlogController {

    private final  BlogService blogService;

    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog){
        return ResponseEntity.ok(blogService.addBlog(blog));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Blog>> getAll(){
        return ResponseEntity.ok(blogService.getAllBlog());
    }
}
