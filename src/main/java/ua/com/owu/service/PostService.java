package ua.com.owu.service;

import ua.com.owu.entity.Post;

import java.util.List;

public interface PostService {

    void save(Post post);

    Post findOne(int id);

    List<Post> findAll();

    void delete(int id);

    List<Post> findTraveling(String postcategory);
}
