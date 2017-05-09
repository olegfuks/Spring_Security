package ua.com.owu.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String blogTitle;
    @Column(columnDefinition = "TEXT")
    private String blogDescription;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "blog")
    private List<Post> posts = new ArrayList<Post>();
    private String avatar;

    public Blog() {
    }

    public Blog(String blogTitle, String blogDescription) {
        this.blogTitle = blogTitle;
        this.blogDescription = blogDescription;
    }

    public Blog(String blogTitle, String blogDescription, String avatar) {
        this.blogTitle = blogTitle;
        this.blogDescription = blogDescription;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }


    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogDescription='" + blogDescription + '\'' +
                '}';
    }
}