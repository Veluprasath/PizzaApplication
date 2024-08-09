package com.example.AuthApplication.controller;

import com.example.AuthApplication.domain.User;
import com.example.AuthApplication.exception.UserNotFoundException;
import com.example.AuthApplication.service.SecurityTokenGenrator;
import com.example.AuthApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/auth-app")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityTokenGenrator securityTokenGenrator;

    @PostMapping("/addUser")
    public ResponseEntity<?> userSave(@RequestBody User user){
        user.setRole("User");
//        user.setStatus("InActive");
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }


    //Method to Fetch All The User
    @GetMapping("/fetchAllUser")
    public ResponseEntity<?> fetchUsers(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user)throws UserNotFoundException {
        try {
            User user1=userService.checkLogIn(user.getEmailId(), user.getPassword());
            Map<String,String> secretkey=new HashMap<>();
            secretkey=securityTokenGenrator.generateToken(user1);
            return new ResponseEntity<>(secretkey,HttpStatus.OK);
        }catch (UserNotFoundException userNotFoundException){
            throw new UserNotFoundException();
        }catch (Exception exception){
            return new ResponseEntity<>("!NETWORK ERROR",HttpStatus.OK);
        }
    }
}
