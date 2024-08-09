package com.example.ProductApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.MongoId;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pizza {
    @MongoId
    private int pizzaId;
    private String pizzaName;
    private String pizzaSize;
    private int pizzaPrice;
    private int pizzaQuantity;
}
