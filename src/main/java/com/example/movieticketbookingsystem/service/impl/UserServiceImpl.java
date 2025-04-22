package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.Exception.EmailAlreadyExistException;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.enums.Role;
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

    @Override
    public UserDetails userRegister(UserDetails userDetails) {
        if(userRepository.existsByEmail(userDetails.getEmail())){
            throw new EmailAlreadyExistException("user mail alredy exist `"+userDetails.getEmail());
        }
       if(userDetails.getRole()==Role.USER){
           User user=new User();
           user.setUserId(userDetails.getUserId());
           user.setUsername(userDetails.getUsername());
           user.setEmail(userDetails.getEmail());
           user.setPassword(userDetails.getPassword());
           user.setRole(userDetails.getRole());
           user.setPhoneNumber(userDetails.getPhoneNumber());
           user.setDateOfBirth(userDetails.getDateOfBirth());
           user.setCreatedAt(userDetails.getCreatedAt());
           user.setUpdatedAt(userDetails.getUpdatedAt());
           return userRepository.save(user);
       }

        else{
            TheaterOwner theaterOwner=new TheaterOwner();
           theaterOwner.setUserId(userDetails.getUserId());
           theaterOwner.setUsername(userDetails.getUsername());
           theaterOwner.setEmail(userDetails.getEmail());
           theaterOwner.setPassword(userDetails.getPassword());
           theaterOwner.setRole(userDetails.getRole());
           theaterOwner.setPhoneNumber(userDetails.getPhoneNumber());
           theaterOwner.setDateOfBirth(userDetails.getDateOfBirth());
           theaterOwner.setCreatedAt(userDetails.getCreatedAt());
           theaterOwner.setUpdatedAt(userDetails.getUpdatedAt());
           return userRepository.save(theaterOwner);
       }


    }
}