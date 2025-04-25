package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.entity.Theater;
import com.example.movieticketbookingsystem.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TheaterRepository extends JpaRepository<Theater,String> {

}
