package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.ScreenRequest;
import com.example.movieticketbookingsystem.dto.ScreenResponse;
import com.example.movieticketbookingsystem.service.ScreenService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.StructureResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ScreenController {

    private ScreenService screenService;
    private StructureResponseBuilder structureResponseBuilder;

    public ResponseEntity<ResponseStructure<ScreenResponse>> createScreen(ScreenRequest screenRequest,String theaterId){
        return structureResponseBuilder.success(HttpStatus.OK,"screen successfully created", screenService.createScreen(screenRequest,theaterId));
    }


}
