package com.example.PizzaProductApplication.service;

import com.example.PizzaProductApplication.domain.Pizza;
import com.example.PizzaProductApplication.exception.PizzaAlreadyExistsException;
import com.example.PizzaProductApplication.exception.PizzaNotFoundException;
import com.example.PizzaProductApplication.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService{

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public Pizza addPizza(Pizza pizza) throws PizzaAlreadyExistsException {
        return pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza updatePizza(int pizzaId, Pizza pizza) throws PizzaNotFoundException {
//        return pizzaRepository.save(pizza);
        Pizza retrivedPizza = pizzaRepository.findById(pizzaId).get();
        if (pizza.getPizzaName() != null) {
            retrivedPizza.setPizzaName(pizza.getPizzaName());
        }
        if (pizza.getPizzaSize() != null) {
            retrivedPizza.setPizzaSize(pizza.getPizzaSize());
        }
        if (pizza.getPizzaPrice() != 0) {
            retrivedPizza.setPizzaPrice(pizza.getPizzaPrice());
        }
        if (pizza.getPizzaQuantity()!= 0) {
            retrivedPizza.setPizzaQuantity(pizza.getPizzaQuantity());
        }
        return pizzaRepository.save(retrivedPizza);
    }

    @Override
    public boolean deletePizza(int pizzaId) throws PizzaNotFoundException{
        boolean flag = false;
        if(pizzaRepository.findById(pizzaId).isEmpty()){
            throw new PizzaNotFoundException();
        }else{
            pizzaRepository.deleteById(pizzaId);
            flag = true;
        }
        return flag;
    }
}
