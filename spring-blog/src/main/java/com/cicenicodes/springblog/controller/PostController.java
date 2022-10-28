package com.cicenicodes.springblog.controller;

import com.cicenicodes.springblog.entity.Post;
import com.cicenicodes.springblog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:3000")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/post/{id}")
    public Optional<Post> getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PostMapping("/createPost")
    public Post CreateNewPost(@RequestBody Post post){
        return postService.savePost(post);
    }

    @PostMapping("/deletePost/{id}")
    public boolean deletePost(@PathVariable Long id){
        var exists = postService.getPostById(id).stream().count();
        if(exists > 0 ){
            postService.deletePostById(id);
            return true;
        }
        return false;
    }

}
