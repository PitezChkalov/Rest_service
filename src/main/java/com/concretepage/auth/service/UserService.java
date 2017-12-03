package com.concretepage.auth.service;

import com.concretepage.auth.dao.UserDao;
import com.concretepage.auth.entity.User;
import com.concretepage.auth.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public User getUserByUsername(String username) {
        try{
        User obj = userDao.getUserByUsername(username);

        return obj;}
        catch (Exception e){
            System.out.println(e.getMessage());
        } return null;
    }
    @Override
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    @Override
    public synchronized boolean addUser(User user){
        if (userDao.userExists(user.getUsername(), user.getPassword())) {
            return false;
        } else {
            UserRole userRole = new UserRole(user, "ROLE_USER");
            Set<UserRole> roles = new HashSet<>(); roles.add(userRole);
            user.setUserRole(roles);
            userDao.addUser(user, userRole);
            return true;
        }
    }

    @Override
    public void deleteUser(String username) {
        userDao.deleteUser(username);
    }

    public boolean userExists(String username, String password){
       return userDao.userExists(username,password);
    }

}
