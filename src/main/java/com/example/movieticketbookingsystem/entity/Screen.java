package com.example.movieticketbookingsystem.entity;

import com.example.movieticketbookingsystem.enums.ScreenType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String screenId;
    private ScreenType screenType;
    private Integer capacity;
    private Integer noOfRows;
    private Long createdAt;
    private Long updatedAt;
    private String createdBy;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "screen",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @OrderBy("seatName ASC")
    private List<Seat> seats;



}
