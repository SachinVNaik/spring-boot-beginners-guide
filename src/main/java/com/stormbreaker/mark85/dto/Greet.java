package com.stormbreaker.mark85.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
// using the @Data will automatically generate the getters, setters, equals and hashcode method for all the fields

@AllArgsConstructor
// Generates a constructor with all the arguments
// Ex: new Greet(statusCode, message);

@NoArgsConstructor
// Generates a constructor with no arguments
// Ex: new Greet();
public class Greet implements Serializable {
    private Integer status;

    private String message;
}
