package com.virtusa.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.virtusa.DAO.UserRepository;
import com.virtusa.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    @Override
    public Optional<User> getUserDetails(int id){
        return userRepository.findById(id);
    }

    @Override
    public void updateUserDetails(User oldUser, User newUser) {
        oldUser.setCreditCardNo(newUser.getCreditCardNo());


    }




}