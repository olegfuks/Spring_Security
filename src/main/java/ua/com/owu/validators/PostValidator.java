package ua.com.owu.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.com.owu.entity.Post;

@Component
public class PostValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return aClass.equals(Post.class);
    }

    public void validate(Object target, Errors errors) {
        Post post = (Post) target;
        if (post.getPosttitle().contains("fuck")){
            errors.rejectValue("posttitle","kartoshka","worng title");
        }
    }
}
