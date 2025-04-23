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
    private void populateCommonFields(UserDetails userDetails, UserUpdationRequest ur) {
        userDetails.setUsername(ur.username());
        userDetails.setPhoneNumber(ur.phoneNumber());
        userDetails.setDateOfBirth(ur.dateOfBirth());
    }
    public User updateUser(User user,UserUpdationRequest ur){
        populateCommonFields(user,ur);
        return user;
    }
    public TheaterOwner updateTheater(UserUpdationRequest ur){
        TheaterOwner theaterOwner=new TheaterOwner();
        populateCommonFields(theaterOwner,ur);
        return theaterOwner;
    }

    public UserUpdationResponse toUserDetails(UserDetails us){

        return new UserUpdationResponse(us.getUsername(),us.getPhoneNumber(),us.getDateOfBirth(),us.getCreatedAt(),us.getUpdatedAt());
    }
}
