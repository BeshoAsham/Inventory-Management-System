package com.project.pr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.project.pr.models.warehouse;
import com.project.pr.models.product;
import java.io.Serializable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor

public class warehouseProductDto implements Serializable {
    private warehouse warehouse;
    private product product;
}
