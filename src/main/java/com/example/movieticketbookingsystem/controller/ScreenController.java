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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class ScreenController {

    private ScreenService screenService;
    private StructureResponseBuilder structureResponseBuilder;
    @PostMapping("/screen")
    public ResponseEntity<ResponseStructure<ScreenResponse>> createScreen(@RequestBody ScreenRequest screenRequest, @PathVariable String theaterId){
        return structureResponseBuilder.success(HttpStatus.OK,"screen successfully created", screenService.createScreen(screenRequest,theaterId));
    }


}
