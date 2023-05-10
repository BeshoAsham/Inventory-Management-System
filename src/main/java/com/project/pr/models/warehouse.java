package com.project.pr.models;

import com.project.pr.enums.status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;


@Entity
@Data
@DynamicInsert
public class warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String location;
    @ColumnDefault("'INACTIVE'")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private status status;
    @Column(length = 11)
    private Integer capacity;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    private user user;
}
