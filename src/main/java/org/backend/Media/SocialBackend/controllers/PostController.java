package org.backend.Media.SocialBackend.controllers;

import org.backend.Media.SocialBackend.entities.Post;
import org.backend.Media.SocialBackend.service.PostService;
import org.backend.Media.SocialBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Post> Hellow(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByUserName(name).getUsers_posts();

    }

    @GetMapping("/all")
    public  List<Post> getALL(){
        return postService.findAll();
    }

    @PostMapping("/post")
    public ResponseEntity<?> data(@RequestParam("file") MultipartFile file, @ModelAttribute Post post){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        try {
            postService.save(post,file,name);
            return  new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
