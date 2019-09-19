package com.virtusa.Service;

import com.virtusa.Entity.User;


import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<User> getAllUsers();
    //public void updateUser(User userRecord);
    public Optional<User> getUserDetails(int id);
    public void updateUserDetails(User oldUser, User newUser);
}
