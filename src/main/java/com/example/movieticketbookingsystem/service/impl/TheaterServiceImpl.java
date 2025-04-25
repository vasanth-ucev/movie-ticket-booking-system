package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.Exception.TheaterNotExitsException;
import com.example.movieticketbookingsystem.dto.TheaterRegistrationRequest;
import com.example.movieticketbookingsystem.dto.TheaterRegistrationResponse;
import com.example.movieticketbookingsystem.dto.TheaterUpdateRequest;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.entity.TheaterOwner;
import com.example.movieticketbookingsystem.entity.UserDetails;
import com.example.movieticketbookingsystem.mapper.TheaterRegistrationMapper;
import com.example.movieticketbookingsystem.repository.TheaterRepository;
import com.example.movieticketbookingsystem.repository.UserRepository;
import com.example.movieticketbookingsystem.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;
    private final TheaterRegistrationMapper theaterRegistrationMapper;
    private final UserRepository userRepository;
    @Override
    public TheaterRegistrationResponse registerTheater(TheaterRegistrationRequest theaterRegistrationRequest, String email) {
        UserDetails details =userRepository.findByEmail(email);
        if (!(details instanceof TheaterOwner)) {
            throw new NoSuchElementException("no theater owner extis") ;
        }
        TheaterOwner theaterOwner=(TheaterOwner)details;
        Theater theater=theaterRegistrationMapper.mapTheaterRequest(theaterRegistrationRequest,theaterOwner);

        return theaterRegistrationMapper.mapTheaterResponse(theaterRepository.save(theater));
    }

    @Override
    public TheaterRegistrationResponse findTheaterById(String id) {
        Theater theater = theaterRepository.findById(id).orElseThrow(() -> new TheaterNotExitsException("no theater found in this id"+id));
        return theaterRegistrationMapper.mapTheaterResponse(theater);
    }

    @Override
    public TheaterRegistrationResponse updateTheaterById(TheaterUpdateRequest theaterUpdateRequest, String id) {
       Optional<Theater> optional=theaterRepository.findById(id);
       if(optional.isEmpty()){
           throw new TheaterNotExitsException("no theater is present in this id "+ id);
       }
       Theater theater=optional.get();
      return theaterRegistrationMapper.updateTheaterRequest(theaterUpdateRequest,theater);
    }
}
