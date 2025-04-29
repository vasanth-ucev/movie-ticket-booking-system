package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.TheaterRegistrationRequest;
import com.example.movieticketbookingsystem.dto.TheaterRegistrationResponse;
import com.example.movieticketbookingsystem.dto.TheaterUpdateRequest;
import com.example.movieticketbookingsystem.service.TheaterService;
import com.example.movieticketbookingsystem.utility.ResponseStructure;
import com.example.movieticketbookingsystem.utility.StructureResponseBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class TheaterController {
    private  final TheaterService theaterService;
    private final StructureResponseBuilder structureResponseBuilder;

    @PostMapping("/register-theater")
    public ResponseEntity<ResponseStructure<TheaterRegistrationResponse>> registerTheater(@RequestBody TheaterRegistrationRequest theaterRegistrationRequest,@RequestParam String email){
        return structureResponseBuilder.success(HttpStatus.OK,"theater register successfully",theaterService.registerTheater(theaterRegistrationRequest,email));
    }

    @GetMapping("/find-theater")
    public ResponseEntity<ResponseStructure<TheaterRegistrationResponse>> findTheaterById(@RequestParam String id) {
        return structureResponseBuilder.success(HttpStatus.FOUND, "find the theater is success", theaterService.findTheaterById(id));
    }

    @PutMapping("/update-theater")
    public ResponseEntity<ResponseStructure<TheaterRegistrationResponse>> updateTheaterBYId(@RequestBody TheaterUpdateRequest theaterUpdateRequest,@RequestParam String id){
        return structureResponseBuilder.success(HttpStatus.OK,"update theater is successfully done",theaterService.updateTheaterById(theaterUpdateRequest,id));
    }

}
