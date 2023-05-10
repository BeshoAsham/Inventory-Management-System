package com.project.pr.controllers;

import com.project.pr.models.product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.pr.services.productService;
import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    private final productService productService;

    public productController(productService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public List<product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/admin/create")
    public ResponseEntity<product> createProduct(@RequestBody product newProduct) {
        productService.createProduct(newProduct);
        return new ResponseEntity<product>(newProduct, HttpStatus.OK);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<product> updateProduct(@RequestBody product updatedProduct) {
        productService.updateProduct(updatedProduct);
        return new ResponseEntity<product>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete")
    public String deleteProduct(@RequestParam Integer ID) {
        productService.deleteProduct(ID);
        return "deleted successfully";
    }
}
