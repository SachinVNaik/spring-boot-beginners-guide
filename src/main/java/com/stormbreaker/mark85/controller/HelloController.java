package com.stormbreaker.mark85.controller;

import com.stormbreaker.mark85.dto.Greet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/v1")
public class HelloController {

    // Effective path of this API is {host}:{port}/api/v1/greet
    @GetMapping("/greet")
    public ResponseEntity<Greet> greet() {
        Greet greet = new Greet(HttpStatus.OK.value(), "You are welcome here");
        // using an object to send the response will set the response format to json
        // remember to use serializable interface in the dto class
        return new ResponseEntity<>(greet, HttpStatus.OK);
    }
}
