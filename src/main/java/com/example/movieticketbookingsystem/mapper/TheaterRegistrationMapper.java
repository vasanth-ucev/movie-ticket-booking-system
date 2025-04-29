package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.TheaterRegistrationRequest;
import com.example.movieticketbookingsystem.dto.TheaterRegistrationResponse;
import com.example.movieticketbookingsystem.dto.TheaterUpdateRequest;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import org.springframework.stereotype.Component;

@Component
public class TheaterRegistrationMapper {
    long now= System.currentTimeMillis();
    public Theater mapTheaterRequest(TheaterRegistrationRequest theaterRegistrationRequest, TheaterOwner theaterOwner){
        return Theater.builder()
                .name(theaterRegistrationRequest.name())
                .address(theaterRegistrationRequest.address())
                .city(theaterRegistrationRequest.city())
                .landmark(theaterRegistrationRequest.landmark())
                .createdAt(now)
                .updatedAt(now)
                .createdBy(theaterOwner.getEmail())
                .theaterOwner(theaterOwner)
                .build();
    }
    public TheaterRegistrationResponse mapTheaterResponse(Theater theater){
        return TheaterRegistrationResponse.builder()
                .name(theater.getName())
                .address(theater.getAddress())
                .city(theater.getCity())
                .landmark(theater.getLandmark())
                .build();

    }

    public TheaterRegistrationResponse updateTheaterRequest(TheaterUpdateRequest theaterUpdateRequest, Theater theater){
        if(theaterUpdateRequest.name()!=null){
           theater.setName(theaterUpdateRequest.name());
        }
        if(theaterUpdateRequest.address()!=null){
            theater.setAddress(theaterUpdateRequest.address());
        }
        if(theaterUpdateRequest.city()!=null){
            theater.setCity(theaterUpdateRequest.city());
        }
        if(theaterUpdateRequest.landmark()!=null){
            theater.setLandmark(theaterUpdateRequest.landmark());
        }
        return new TheaterRegistrationResponse(theater.getName(),theater.getAddress(),theater.getCity(),theater.getLandmark(),theater.getCreatedAt(),theater.getUpdatedAt());
    }

}
