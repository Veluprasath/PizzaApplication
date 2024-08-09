package com.example.AuthApplication.service;


import com.example.AuthApplication.domain.User;
import com.example.AuthApplication.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
     public User addUser(User user);

     public List<User> getAllUser();

     public  User checkLogIn(String emailId , String password) throws UserNotFoundException;
}
