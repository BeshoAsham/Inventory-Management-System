package com.project.pr.controllers;

import com.project.pr.models.warehouse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.pr.services.warehouseService;
import java.util.List;

@RestController
@RequestMapping("/admin/warehouse")
public class warehouseController {

    private final warehouseService warehouseService;

    public warehouseController(warehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/getAll")
    public List<warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @PostMapping("/create")
    public ResponseEntity<warehouse> createWarehouse(@RequestBody warehouse newWarehouse) {
        warehouseService.createWarehouse(newWarehouse);
        return new ResponseEntity<warehouse>(newWarehouse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<warehouse> updateWarehouse(@RequestBody warehouse updatedWarehouse) {
        warehouseService.updateWarehouse(updatedWarehouse);
        return new ResponseEntity<warehouse>(updatedWarehouse, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public String deleteWarehouse(@RequestParam Integer ID) {
        warehouseService.deleteWarehouse(ID);
        return "deleted successfully";
    }
}
