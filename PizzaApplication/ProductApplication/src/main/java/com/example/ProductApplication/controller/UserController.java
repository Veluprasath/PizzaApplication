package com.example.ProductApplication.controller;

import com.example.ProductApplication.domain.Pizza;
import com.example.ProductApplication.domain.User;
import com.example.ProductApplication.exception.PizzaAlreadyExistsException;
import com.example.ProductApplication.exception.PizzaNotFoundException;
import com.example.ProductApplication.exception.UserAlreadyExistsException;
import com.example.ProductApplication.exception.UserNotFoundException;
import com.example.ProductApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/pizza-app")
public class UserController {
    @Autowired
    public UserService userService;

    //Method to Save the User
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user)throws UserAlreadyExistsException{
        try {
            User addedUser=userService.addUser(user);
            return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
        }catch (UserAlreadyExistsException exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
        }
    }


    //Method to Save content by emailId
    @PostMapping("/addToCart/{emailId}")
    public ResponseEntity<?> addPizzaToUser(@RequestBody Pizza pizza, @PathVariable String emailId)
            throws UserNotFoundException, PizzaAlreadyExistsException {
        try {
            User addedPizzaToUser = userService.addToCart(emailId, pizza);
            return new ResponseEntity<>(addedPizzaToUser, HttpStatus.CREATED);
        }catch (UserNotFoundException|PizzaAlreadyExistsException exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
        }
    }



    //Method to Update the content by emailId
    @PutMapping("/updateToCart/{emailId}")
    public ResponseEntity<?> updatePizzaToUser(@RequestBody Pizza pizza, @PathVariable String emailId)
            throws UserNotFoundException, PizzaNotFoundException {
        try {
            User addedPizzaToUser = userService.updateToCart(emailId, pizza);
            return new ResponseEntity<>(addedPizzaToUser, HttpStatus.CREATED);
        }catch (UserNotFoundException|PizzaNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
        }
    }


    //Method to Delete the content by PIZZA NAME
    @DeleteMapping("/deleteToCart/{emailId}/{pizzaName}")
    public ResponseEntity<?> deletePizza(@PathVariable String emailId,@PathVariable String pizzaName)
            throws PizzaNotFoundException{
        try {
            boolean deletePizzaById=userService.deleteToCart(emailId, pizzaName);
            return new ResponseEntity<>(deletePizzaById,HttpStatus.OK);
        } catch (PizzaNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.CONFLICT);
        }
    }


    @GetMapping("/fetchUser/{emailId}")
    public ResponseEntity<?> getUser(@PathVariable String emailId){
        return new ResponseEntity<>(userService.getByEmailId(emailId),HttpStatus.OK);
    }

}
