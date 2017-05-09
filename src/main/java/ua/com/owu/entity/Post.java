package ua.com.owu.entity;


import javax.persistence.*;

@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String posttitle;
    @Column(columnDefinition = "TEXT")
    private String postdescription;
    @Column(columnDefinition = "TEXT")
    private String posttext;
    private String postcategory;
    private String postdate;
    private String picture;
    private String owner;

    @ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.MERGE)
    private Blog blog;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Post() {
    }

    public Post(String posttitle, String posttext, String postcategory, String postdate, String picture) {

        this.posttitle = posttitle;
        this.posttext = posttext;
        this.postcategory = postcategory;
        this.postdate = postdate;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }

    public String getPosttext() {
        return posttext;
    }

    public void setPosttext(String posttext) {
        this.posttext = posttext;
    }

    public String getPostcategory() {
        return postcategory;
    }

    public void setPostcategory(String postcategory) {
        this.postcategory = postcategory;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPostdescription() {
        return postdescription;
    }

    public void setPostdescription(String postdescription) {
        this.postdescription = postdescription;
    }

    @Override
    public String toString() {
        return "Post{" +
                "posttitle='" + posttitle + '\'' +
                ", posttext='" + posttext + '\'' +
                ", postcategory='" + postcategory + '\'' +
                ", postdate='" + postdate + '\'' +
                '}';
    }
}
