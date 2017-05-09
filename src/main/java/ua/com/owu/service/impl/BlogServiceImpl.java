package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.BlogDAO;
import ua.com.owu.entity.Blog;
import ua.com.owu.service.BlogService;

import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDAO blogDAO;

    public void save(String blogTitle, String blogDiscription) {
        if(!blogTitle.isEmpty() && blogTitle != null && !blogDiscription.isEmpty() && blogDiscription != null){
            blogDAO.save(new Blog(blogTitle, blogDiscription));
        } else{
            System.out.println("faq");
        }
    }

    public void save(Blog blog) {
        if (blog != null) {
            blogDAO.save(blog);
        }else {
            System.out.println("faq");
        }
    }

    public Blog findOne(int id) {
        return blogDAO.findOne(id);
    }

    public List<Blog> findAll() {
        return blogDAO.findAll();
    }

    public void delete(int id) {
            blogDAO.delete(id);
    }

    public void setBlogDAO(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    public void save(String blogTitle, String blogDiscription, String avatar) {
        Blog blog = new Blog(blogTitle, blogDiscription, avatar);
        blogDAO.save(blog);
    }

    public Blog findBlogWithPost(int id) {
        return blogDAO.findBlogWithPost(id);
    }
}
