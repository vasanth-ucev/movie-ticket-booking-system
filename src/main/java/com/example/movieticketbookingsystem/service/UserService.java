package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.TheaterRegistrationResponse;
import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.dto.UserRegistrationResponse;
import com.example.movieticketbookingsystem.dto.UserUpdationRequest;
import com.example.movieticketbookingsystem.dto.UserUpdationResponse;
import com.example.movieticketbookingsystem.entity.UserDetails;

public interface UserService {
    public UserDetails userRegister(UserRegistrationRequest userRegistrationRequest);


}
