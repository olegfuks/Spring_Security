package ua.com.owu.service;

import ua.com.owu.entity.Blog;

import java.util.List;

public interface BlogService {

    void save(String blogTitle, String blogDiscription);
    void save(String blogTitle, String blogDiscription, String avatar);

    void save(Blog blog);

    Blog findOne(int id);

    List<Blog> findAll();

    void delete(int id);

    Blog findBlogWithPost(int id);
}
