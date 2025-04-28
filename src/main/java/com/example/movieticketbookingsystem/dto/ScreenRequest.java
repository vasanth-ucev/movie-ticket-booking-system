package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.ScreenType;
import lombok.Builder;

@Builder
public record ScreenRequest(ScreenType screenType
                            ,Integer capacity
                            ,Integer noOfRow){
}
