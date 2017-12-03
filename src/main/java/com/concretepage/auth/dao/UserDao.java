package com.concretepage.auth.dao;

import com.concretepage.auth.entity.User;
import com.concretepage.auth.entity.UserRole;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUserByUsername(String username);
    void addUser(User user, UserRole role);
    void deleteUser(String username);
    boolean userExists(String username, String password);
}