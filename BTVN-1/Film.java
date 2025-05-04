package com.example.demo.BTVN;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    private int id;
    private String name;
    private String genre;
    private String director;
    private double duration; // theo giờ
    private String description;
    private LocalDate publishedDate;
    private String category;
}
