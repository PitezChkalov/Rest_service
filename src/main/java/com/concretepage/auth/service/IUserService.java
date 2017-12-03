package com.concretepage.auth.service;

import com.concretepage.auth.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();
    User getUserByUsername(String username);
    boolean addUser(User article);
    void deleteUser(String username);
    boolean userExists(String username, String password);
}
