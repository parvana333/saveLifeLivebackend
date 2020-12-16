package com.education.savelifeliveapi.controller;

import com.education.savelifeliveapi.model.Blog;
import com.education.savelifeliveapi.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("blog")
@RequiredArgsConstructor
@Slf4j
public class BlogController {
    private final  BlogService blogService;
    @PostMapping("save/{id}")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog, @PathVariable Long id){
        return ResponseEntity.ok(blogService.addBlog(blog,id));

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Blog>> getAll(){
        return ResponseEntity.ok(blogService.getAllBlog());
    }
}
