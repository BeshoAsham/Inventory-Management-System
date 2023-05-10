package com.project.pr.services;

import com.project.pr.models.warehouseProduct;
import com.project.pr.repositories.warehouseProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class warehouseProductService {
    private final warehouseProductRepository warehouseProductRepository;

    public warehouseProductService(warehouseProductRepository warehouseProductRepository) {
        this.warehouseProductRepository = warehouseProductRepository;
    }


    public List<warehouseProduct> getAllWarehouseProduct() {
        return warehouseProductRepository.findAll();
    }

    public warehouseProduct createWarehouseProduct(warehouseProduct newWarehouse_Product) {
        if (warehouseProductRepository.existsByWarehouseAndProduct(newWarehouse_Product.getWarehouse(), newWarehouse_Product.getProduct())) {
            return null;
        } else {
          return  warehouseProductRepository.save(newWarehouse_Product);
        }
    }




    public void deleteWarehouseProduct(warehouseProduct deletedWarehouse_Product) {
        warehouseProductRepository.delete(deletedWarehouse_Product);
    }
}
