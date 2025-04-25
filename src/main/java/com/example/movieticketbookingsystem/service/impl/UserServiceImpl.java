package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.Exception.EmailAlreadyExistException;
import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.enums.Role;
import com.example.movieticketbookingsystem.mapper.UserRegistrationMapper;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.UserService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRegistrationMapper userRegistrationMapper;

    @Override
    public UserDetails userRegister(UserRegistrationRequest userRegistrationRequest) {
        if(userRepository.existsByEmail(userRegistrationRequest.email())){
            throw new EmailAlreadyExistException("user mail already exist `"+userRegistrationRequest.email());
        }
       if(userRegistrationRequest.role()==Role.USER){
           return userRepository.save(userRegistrationMapper.toUser(userRegistrationRequest));
       }

        else{
           return userRepository.save(userRegistrationMapper.toTheater(userRegistrationRequest));
       }


    }


}