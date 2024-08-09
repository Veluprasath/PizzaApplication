package com.example.ProductApplication.service;

import com.example.ProductApplication.domain.Pizza;
import com.example.ProductApplication.domain.User;
import com.example.ProductApplication.exception.PizzaAlreadyExistsException;
import com.example.ProductApplication.exception.PizzaNotFoundException;
import com.example.ProductApplication.exception.UserAlreadyExistsException;
import com.example.ProductApplication.exception.UserNotFoundException;
import com.example.ProductApplication.proxy.UserProxy;
import com.example.ProductApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private UserProxy userProxy;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserProxy userProxy) {
        this.userRepository = userRepository;
        this.userProxy = userProxy;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        Optional opt= userRepository.findById(user.getEmailId());
            if (opt.isEmpty()){
                userProxy.userSave(user);
                return userRepository.save(user);
            }else {
                throw new UserAlreadyExistsException();
            }
        }

    @Override
    public User addToCart(String emailId, Pizza pizza) throws UserNotFoundException , PizzaAlreadyExistsException {
        //add content by emailId and content data implementation
        if (userRepository.findById(emailId).isPresent())
            {
                User existingUser=userRepository.findById(emailId).get();
                List<Pizza> pizzaList=existingUser.getPizzaList();
                if (pizzaList==null){
                    existingUser.setPizzaList(Arrays.asList(pizza));

                }else {
                    if (pizzaList.stream().filter(pizzaObj->pizzaObj.getPizzaName().equals(pizza.getPizzaName()))
                            .findAny().isPresent()){
                        throw new PizzaAlreadyExistsException();
                    }else {
                        pizzaList.add(pizza);
                        existingUser.setPizzaList(pizzaList);
                    }
                }
                return userRepository.save(existingUser);
            }else {
                throw new UserNotFoundException();
            }
        }

    @Override
    public User updateToCart(String emailId, Pizza pizza) throws UserNotFoundException , PizzaNotFoundException {

            if (userRepository.findById(emailId).isPresent())
            {
                User user = userRepository.findById(emailId).get();
                List<Pizza> pizzaList = user.getPizzaList();
                if (pizzaList == null) {
                    throw new PizzaNotFoundException();
                } else {
                    int index = -1;
                    Iterator<Pizza> pizzaIterator = pizzaList.listIterator();
                    while (pizzaIterator.hasNext()) {
                        Pizza pizzaObj = pizzaIterator.next();
                        if (pizzaObj.getPizzaName().equals(pizza.getPizzaName())) {
                            index = pizzaList.indexOf(pizzaObj);
                        }
                    }
                    if (index == -1) {
                        throw new PizzaNotFoundException();
                    } else {
                        pizzaList.set(index, pizza);
                        user.setPizzaList(pizzaList);
                    }
                }
                return userRepository.save(user);
            }
            else {
                throw new UserNotFoundException();
            }
        }

    @Override
    public boolean deleteToCart(String emailId, String pizzaName) throws PizzaNotFoundException {
        if (userRepository.findById(emailId).isPresent()){
            User user=userRepository.findById(emailId).get();
            List<Pizza>pizzaList=user.getPizzaList();
            Iterator<Pizza> pizzaIterator=pizzaList.listIterator();
            while (pizzaIterator.hasNext()){
                Pizza pizza=pizzaIterator.next();
                if (pizza.getPizzaName().equals(pizzaName)){
                    pizzaIterator.remove();
                }
            }
            user.setPizzaList(new ArrayList<>());
            user.setPizzaList(pizzaList);
            userRepository.save(user);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<User> getByEmailId(String emailId) {
        return userRepository.findByEmailId(emailId);
    }


}
