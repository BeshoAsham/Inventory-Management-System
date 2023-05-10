package com.project.pr.repositories;

import com.project.pr.models.product;
import com.project.pr.models.warehouse;
import com.project.pr.models.warehouseProduct;
import com.project.pr.dto.warehouseProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface warehouseProductRepository extends JpaRepository<warehouseProduct, warehouseProductDto> {

    boolean existsByWarehouseAndProduct(warehouse warehouse, product product);

}
