package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.StructureResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @Autowired
    private StructureResponseBuilder structureResponseBuilder;
    @PostMapping
    public ResponseEntity<ResponseStructure<UserDetails>> registerUser(@RequestBody UserDetails userDetails) {
        UserDetails userDetails1 = userService.userRegister(userDetails);
        return structureResponseBuilder.success(HttpStatus.CREATED,"user registeration succssefully done",userDetails1);
    }


}
