package com.example.movieticketbookingsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String theaterId;
    private String name;
    private String address;
    private String city;
    private String landmark;
    private Long createdAt;
    private Long updatedAt;
    private String createdBy;

    @ManyToOne
    private TheaterOwner theaterOwner;
}
