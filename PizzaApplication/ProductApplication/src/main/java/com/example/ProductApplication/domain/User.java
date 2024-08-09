package com.example.ProductApplication.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class User {

    @MongoId
    private String emailId;
    private String userName;
    private String password;
    private String address;
    private String contactNumber;
    private List<Pizza> pizzaList;
}
