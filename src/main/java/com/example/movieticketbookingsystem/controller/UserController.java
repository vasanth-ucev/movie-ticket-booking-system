package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.dto.UserRegistrationResponse;
import com.example.movieticketbookingsystem.dto.UserUpdationRequest;
import com.example.movieticketbookingsystem.dto.UserUpdationResponse;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.mapper.UserRegistrationMapper;
import com.example.movieticketbookingsystem.mapper.UserUpdationMapper;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.StructureResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRegistrationMapper userRegistrationMapper;
    private final UserUpdationMapper userUpdationMapper;
    private StructureResponseBuilder structureResponseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserRegistrationResponse>> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        UserDetails details = userService.userRegister(userRegistrationRequest);
        return structureResponseBuilder.success(HttpStatus.CREATED,"user registration successfully done",userRegistrationMapper.toUserDetails(details));
    }

    @PutMapping("/user/{email}")
    public ResponseEntity<ResponseStructure<UserUpdationResponse>> updateUser(@PathVariable String email, UserUpdationRequest userUpdationRequest){

        return structureResponseBuilder.success(HttpStatus.OK,"user updation successfully done", userService.updateUser(email,userUpdationRequest));
    }

    


}
