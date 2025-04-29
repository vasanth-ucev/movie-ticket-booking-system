package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.UserRegistrationRequest;
import com.example.movieticketbookingsystem.dto.UserRegistrationResponse;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.User;
import com.example.movieticketbookingsystem.entity.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationMapper {
    private void populateCommonFields(UserDetails userDetails, UserRegistrationRequest urr) {
        userDetails.setUsername(urr.username());
        userDetails.setEmail(urr.email());
        userDetails.setPassword(urr.password());
        userDetails.setRole(urr.role());
        userDetails.setPhoneNumber(urr.phoneNumber());
        userDetails.setDateOfBirth(urr.dateOfBirth());
    }
    public User toUser(UserRegistrationRequest urr){
        User user=new User();
       populateCommonFields(user,urr);
        return user;
    }
    public TheaterOwner toTheater(UserRegistrationRequest urr){
       TheaterOwner theaterOwner=new TheaterOwner();
       populateCommonFields(theaterOwner,urr);
        return theaterOwner;
    }

    public UserRegistrationResponse toUserDetails(UserDetails us){

        return new UserRegistrationResponse(us.getUsername(),us.getEmail(),us.getPhoneNumber(),us.getRole(),us.getDateOfBirth());
    }
}