package com.example.PizzaProductApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pizza {

    @Id
    @GeneratedValue
    private int pizzaId;
    private String pizzaName;
    private String pizzaSize;
    private int pizzaPrice;
    private int pizzaQuantity;
}
