package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.User;
import com.example.AuthApplication.exception.UserNotFoundException;
import com.example.AuthApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User checkLogIn(String emailId, String password) throws UserNotFoundException {
        User user = userRepository.findByEmailIdAndPassword(emailId, password);
        if(user==null){
            throw new UserNotFoundException();
        }
        return user;
    }
}
