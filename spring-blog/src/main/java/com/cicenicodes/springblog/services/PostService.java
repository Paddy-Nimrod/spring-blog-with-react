package com.cicenicodes.springblog.services;

import com.cicenicodes.springblog.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getAllPosts();

    Optional<Post> getPostById(Long id);
    
    Post savePost(Post post);

    void deletePostById(Long id);

}
