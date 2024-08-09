package com.example.PizzaProductApplication.controller;

import com.example.PizzaProductApplication.domain.Pizza;
import com.example.PizzaProductApplication.exception.PizzaAlreadyExistsException;
import com.example.PizzaProductApplication.exception.PizzaNotFoundException;
import com.example.PizzaProductApplication.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/pizza-product-app")
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/addPizza")
    public ResponseEntity<?> addPizza(@RequestBody Pizza pizza)throws PizzaAlreadyExistsException {
        return new ResponseEntity<>(pizzaService.addPizza(pizza), HttpStatus.CREATED);
    }


    @GetMapping("/fetchAllPizza")
    public ResponseEntity<?>fetchPizza() {
        ResponseEntity responseEntity=null;
        try {
            responseEntity=new ResponseEntity<>(pizzaService.getAllPizza(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return responseEntity;
    }


    @PutMapping("/updatePizza/{pizzaId}")
    public ResponseEntity<?> updatePizza(@PathVariable int pizzaId,@RequestBody Pizza pizza) throws PizzaNotFoundException{
        return new ResponseEntity<>(pizzaService.updatePizza(pizzaId,pizza),HttpStatus.OK);
    }

    //Delete by id
    @DeleteMapping("/deletePizza/{pizzaId}")
    public ResponseEntity<?> deletePizza(@PathVariable int pizzaId)throws PizzaNotFoundException {
        ResponseEntity responseEntity=null;
        try {
            pizzaService.deletePizza(pizzaId);
            responseEntity=new ResponseEntity<>("successfully deleted",HttpStatus.OK);
        }catch (PizzaNotFoundException e){
            throw new PizzaNotFoundException();
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
