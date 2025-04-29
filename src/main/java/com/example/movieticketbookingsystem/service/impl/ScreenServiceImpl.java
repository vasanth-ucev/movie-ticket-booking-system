package com.example.movieticketbookingsystem.service.impl;

import com.example.movieticketbookingsystem.Exception.TheaterNotExitsException;
import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.dto.ScreenResponse;
import com.example.movieticketbookingsystem.dto.SeatResponse;
import com.example.movieticketbookingsystem.entity.Screen;
import com.example.movieticketbookingsystem.entity.Seat;
import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.mapper.ScreenMapper;
import com.example.movieticketbookingsystem.mapper.SeatMapper;
import com.example.movieticketbookingsystem.repository.ScreenRepository;
import com.example.movieticketbookingsystem.repository.SeatRepository;
import com.example.movieticketbookingsystem.repository.TheaterRepository;
import com.example.movieticketbookingsystem.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {
    private ScreenRepository screenRepository;
    private TheaterRepository theaterRepository;
    private ScreenMapper screenMapper;
    private SeatMapper seatMapper;
    private SeatRepository seatRepository;
    @Override
    public ScreenResponse createScreen(ScreenRequest screenRequest, String theaterId) {
        if(screenRequest.capacity()<screenRequest.noOfRow()){
            throw new RuntimeException("dd,");
        }
        Theater theater = theaterRepository.findById(theaterId).orElseThrow(() -> new TheaterNotExitsException("Theater not found"));
        Screen screen=screenMapper.toScreen(screenRequest,theater);
        List<Seat> seats =seatMapper.toSeat(screen);
        screen.setSeats(seats);
        Screen savedScreen=screenRepository.save(screen);
        List<SeatResponse> seatResponseList = seatMapper.toSeatResponseList(seatRepository.saveAll(seats));
        return screenMapper.toScreenResponse(savedScreen, seatResponseList);
    }
}
