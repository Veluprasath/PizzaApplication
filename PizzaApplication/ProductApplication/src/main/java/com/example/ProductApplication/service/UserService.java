package com.example.ProductApplication.service;

import com.example.ProductApplication.domain.Pizza;
import com.example.ProductApplication.domain.User;
import com.example.ProductApplication.exception.PizzaAlreadyExistsException;
import com.example.ProductApplication.exception.PizzaNotFoundException;
import com.example.ProductApplication.exception.UserAlreadyExistsException;
import com.example.ProductApplication.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    public User addUser(User user) throws UserAlreadyExistsException;

    public User addToCart(String emailId ,Pizza pizza) throws UserNotFoundException,PizzaAlreadyExistsException;

    public User updateToCart(String emailId,Pizza pizza) throws UserNotFoundException , PizzaNotFoundException;

    public boolean deleteToCart(String emailId,String pizzaName) throws PizzaNotFoundException;

    public List<User> getByEmailId(String emailId);
}
