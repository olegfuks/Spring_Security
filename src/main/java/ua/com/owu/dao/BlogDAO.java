package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.Blog;

public interface BlogDAO extends JpaRepository<Blog,Integer>{
    Blog findByIdAndBlogTitleAndBlogDescription(int id, String blogTitle, String description);

    @Query("from Blog b join fetch b.posts where b.id=:id")
    Blog findBlogWithPost(@Param("id") int id);
}
