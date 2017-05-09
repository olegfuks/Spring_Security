package ua.com.owu.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.owu.entity.Blog;

@Component
public class BlogValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Blog.class);
    }

    public void validate(Object target, Errors errors) {
        Blog blog = (Blog) target;
        if (blog.getBlogTitle().contains("fuck")){
            errors.rejectValue("blogTitle","kartoshka","worng title");
        }
    }
}
