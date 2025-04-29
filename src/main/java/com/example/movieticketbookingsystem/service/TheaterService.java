package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.TheaterRegistrationRequest;
import com.example.movieticketbookingsystem.dto.TheaterRegistrationResponse;
import com.example.movieticketbookingsystem.dto.TheaterUpdateRequest;
import com.example.movieticketbookingsystem.entity.Theater;

public interface TheaterService {
    public TheaterRegistrationResponse registerTheater(TheaterRegistrationRequest theaterRegistrationRequest, String email);
    public TheaterRegistrationResponse findTheaterById(String id);
    public TheaterRegistrationResponse updateTheaterById(TheaterUpdateRequest theaterUpdateRequest,String id);
}
