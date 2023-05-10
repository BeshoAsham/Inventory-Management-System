package com.project.pr.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11, nullable = false)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false, length = 11)
    private Integer stock;

}
