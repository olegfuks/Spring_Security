package ua.com.owu.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.Post;

import java.util.List;

public interface PostDAO extends JpaRepository<Post,Integer>{
    @Query("from Post p where p.postcategory=:postcategory")
    List<Post> findTraveling(@Param("postcategory") String postcategory);

//    @Query("from Blog b join fetch b.posts where b.id=:id")
//    Blog findBlogWithPost(@Param("id") int id);

}
