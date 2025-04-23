package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.dto.UserUpdationRequest;
import com.example.movieticketbookingsystem.dto.UserRegistrationResponse;
import com.example.movieticketbookingsystem.dto.UserUpdationResponse;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserUpdationMapper {

    public UserUpdationResponse toUserDetails(UserDetails us){

        return new UserUpdationResponse(us.getUsername(),us.getPhoneNumber(),us.getDateOfBirth(),us.getCreatedAt(),us.getUpdatedAt());
    }
}
