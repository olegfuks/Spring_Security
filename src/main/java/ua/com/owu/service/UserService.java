package ua.com.owu.service;

import ua.com.owu.entity.User;

public interface UserService {
    void save(User user);
    User findByName(String username);


}
