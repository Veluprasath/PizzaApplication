package com.example.PizzaProductApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason = "Pizza Already Exists")
public class PizzaAlreadyExistsException extends Exception{
}
