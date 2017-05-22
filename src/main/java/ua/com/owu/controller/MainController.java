package ua.com.owu.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.editor.BlogEditor;
import ua.com.owu.entity.Blog;
import ua.com.owu.entity.Post;
import ua.com.owu.entity.User;
import ua.com.owu.service.BlogService;
import ua.com.owu.service.MailService;
import ua.com.owu.service.PostService;
import ua.com.owu.service.UserService;
import ua.com.owu.validators.BlogValidator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    BlogService blogService;
    @Autowired
    BlogEditor blogEditor;
    @Autowired
    BlogValidator blogValidator;
    @Autowired
    MailService mailService;

    @GetMapping("/")
    public String toIndex(Model model){
        model.addAttribute("posts", postService.findAll());
        model.addAttribute("blogs",blogService.findAll());
        return "index";
    }


    @PostMapping("save")
    public String save(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("email") String email) {
        User user =  new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userService.save(user);
        mailService.send(user);

        return "redirect:/toLogin";
    }

    @GetMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @GetMapping("registration")
    public String registration(){
        return "registration";
    }

    @GetMapping("/postcreation")
    public String postCreation(Model model){
        model.addAttribute("emptyPost", new Post());
        model.addAttribute("blogs", blogService.findAll());
        return "postcreation";
    }
    @PostMapping("/savepost")
    public String savePost(@ModelAttribute("emptyPost") Post post,
                           @RequestParam("picture")MultipartFile multipartFile){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("M d ',' yyyy");
        post.setPostdate(ft.format(dNow));

//        String path = "C:\\TMP\\";
        String path="C:\\Users\\olegf\\IdeaProjects\\Spring_Security\\TMP\\";
        post.setPicture("/PICTURE/"+multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(new File(path+multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        post.setOwner(username);
        postService.save(post);
        return "redirect:/postcreation";
    }
    @InitBinder("emptyPost")
    public void binder(WebDataBinder binder){
        binder.registerCustomEditor(Blog.class ,blogEditor );
    }

    @ModelAttribute("emptyBlog")
    public Blog blog() {
        return new Blog();
    }

    @PostMapping("saveblog")
    public String saveBlog(@ModelAttribute("emptyBlog") @Validated Blog blog, BindingResult result ,
                           @RequestParam("pic")MultipartFile multipartFile) {
        if(result.hasErrors()){
            return "blogCreationPage";
        }
        String path = "C:\\Users\\olegf\\IdeaProjects\\Spring_Security\\TMP\\";
        blog.setAvatar("/PICTURE/"+multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(new File(path+multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        blogService.save(blog);
        return "redirect:/postcreation";
    }
    @InitBinder("emptyBlog")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(blogValidator);
    }


    @GetMapping("toindex")
    public String toindex(){
        return "redirect:/";
    }

    @GetMapping("/showpost-{id}")
    public String showpost(@PathVariable int id, Model model){
        model.addAttribute("post",postService.findOne(id));
            return "singlepost";
    }
    @GetMapping("ukraine")
    public String poststraveling(Model model){
        model.addAttribute("traveling",postService.findTraveling("Ukraine"));
        return "traveling";
    }

    @GetMapping("europe")
    public String cityguide(Model model){
        model.addAttribute("cityguide",postService.findTraveling("Europe"));
        return "cityguide";
    }

    @GetMapping("world")
    public String lifestyle(Model model){
        model.addAttribute("lifestyle",postService.findTraveling("World"));
        return "lifestyle";
    }
    @GetMapping("/show-blog-{id}")
    public String showblog(@PathVariable int id, Model model){
//        model.addAttribute("blog",blogService.findOne(id));
        model.addAttribute("blog",blogService.findBlogWithPost(id));
        return "singleblog";
    }


}
