package com.project.pr.models;

import com.project.pr.enums.requestStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;


@Entity
@Data
@DynamicInsert
public class stockRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 11)
    private Integer id;
    @Column(length = 11, nullable = false)
    private Integer quantity;
    @ColumnDefault("'PENDING'")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private requestStatus status;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    private warehouse warehouse;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    private product product;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    private user user;

}
