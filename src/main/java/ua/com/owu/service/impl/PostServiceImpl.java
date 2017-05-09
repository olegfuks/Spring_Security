package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.PostDAO;
import ua.com.owu.entity.Post;
import ua.com.owu.service.PostService;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDAO postDAO;



    public void save(Post post) {
        if(post != null) postDAO.save(post);
    }

    public Post findOne(int id) {
        return postDAO.findOne(id);
    }

    public List<Post> findAll() {
        return postDAO.findAll();
    }

    public void delete(int id) {
        postDAO.delete(id);
    }

    public List<Post> findTraveling(String postcategory) {
        return postDAO.findTraveling(postcategory);
    }

    public void setPostDAO(PostDAO postDAO) {
        this.postDAO = postDAO;
    }
}
