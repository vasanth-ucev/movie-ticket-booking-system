package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.dto.ScreenResponse;

public interface ScreenService {
    public ScreenResponse createScreen(ScreenRequest screenRequest,String theaterId);
}
