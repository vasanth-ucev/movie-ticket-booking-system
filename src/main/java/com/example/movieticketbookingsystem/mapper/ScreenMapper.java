package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.dto.ScreenResponse;
import com.example.movieticketbookingsystem.dto.SeatResponse;
import com.example.movieticketbookingsystem.entity.Screen;
import com.example.movieticketbookingsystem.entity.Theater;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScreenMapper {
    long now = System.currentTimeMillis();
    public Screen toScreen(ScreenRequest request, Theater theater) {
        return Screen.builder()
                .screenType(request.screenType())
                .capacity(request.capacity())
                .noOfRows(request.noOfRow())
                .createdAt(now)
                .updatedAt(now)
                .createdBy(theater.getCreatedBy())
                .theater(theater)
                .build();
    }
    public ScreenResponse toScreenResponse(Screen screen, List<SeatResponse> seatResponseList){
        return ScreenResponse.builder()
                .screenId(screen.getScreenId())
                .screenType(screen.getScreenType())
                .capacity(screen.getCapacity())
                .noOfRows(screen.getNoOfRows())
                .createdBy(screen.getCreatedBy())
                .seatResponse(seatResponseList)
                .build();

    }

}
