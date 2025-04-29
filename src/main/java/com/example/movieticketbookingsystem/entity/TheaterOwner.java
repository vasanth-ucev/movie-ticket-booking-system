package com.example.movieticketbookingsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class TheaterOwner extends UserDetails{
    @OneToMany(mappedBy = "theaterOwner")
    private List<Theater> theater;
}
