package com.example.PizzaProductApplication.service;

import com.example.PizzaProductApplication.domain.Pizza;
import com.example.PizzaProductApplication.exception.PizzaAlreadyExistsException;
import com.example.PizzaProductApplication.exception.PizzaNotFoundException;

import java.util.List;

public interface PizzaService {
    public Pizza addPizza(Pizza pizza) throws PizzaAlreadyExistsException;

    public List<Pizza>  getAllPizza();

    public Pizza updatePizza(int pizzaId,Pizza pizza) throws PizzaNotFoundException;

    public boolean deletePizza(int pizzaId) throws PizzaNotFoundException;
}
