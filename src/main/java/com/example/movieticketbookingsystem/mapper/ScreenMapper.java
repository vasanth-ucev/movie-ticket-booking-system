package com.example.movieticketbookingsystem.mapper;

import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.entity.Screen;
import com.example.movieticketbookingsystem.entity.Theater;
import org.springframework.stereotype.Component;

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

}
