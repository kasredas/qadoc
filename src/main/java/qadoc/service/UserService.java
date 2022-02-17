package qadoc.service;

import qadoc.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}