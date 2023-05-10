package com.project.pr.controllers;

import com.project.pr.models.warehouseProduct;
import com.project.pr.services.warehouseProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/warehouseProduct")
public class warehouseProductController {
    private final warehouseProductService warehouse_ProductService;

    public warehouseProductController(warehouseProductService warehouse_ProductService) {
        this.warehouse_ProductService = warehouse_ProductService;
    }

    @GetMapping("/getAll")
    public List<warehouseProduct> getAllWarehouseProduct() {
        return warehouse_ProductService.getAllWarehouseProduct();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createWarehouseProduct(@RequestBody warehouseProduct newWarehouseProduct) {
        warehouseProduct warehouseProductCheck= warehouse_ProductService.createWarehouseProduct(newWarehouseProduct);
        if (warehouseProductCheck == null) {
            return ResponseEntity.badRequest().body("This product already exists in this Warehouse");
        } else {
            return ResponseEntity.ok("The product is added successfully in this Warehouse");
        }
    }

    @DeleteMapping("/delete")
    public String deleteWarehouseProduct(@RequestBody warehouseProduct deletedWarehouse_Product) {
        warehouse_ProductService.deleteWarehouseProduct(deletedWarehouse_Product);
        return "deleted successfully";
    }

}
