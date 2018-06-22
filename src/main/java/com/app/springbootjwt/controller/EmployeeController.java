package com.app.springbootjwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>("Get users",HttpStatus.OK);
    }

    @GetMapping("/getAdminUsers")
    public ResponseEntity<?> getAdminUsers(){
        return new ResponseEntity<>("Get Admin users",HttpStatus.OK);
    }

}
