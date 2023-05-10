package com.project.pr.models;

import com.project.pr.dto.warehouseProductDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(warehouseProductDto.class)
public class warehouseProduct {
    @Id
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    private warehouse warehouse;
    @Id
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(nullable = false)
    private product product;


}

