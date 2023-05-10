package com.project.pr.services;

import com.project.pr.models.product;
import org.springframework.stereotype.Service;
import com.project.pr.repositories.productRepository;

import java.util.List;

@Service
public class productService {
    private final productRepository productRepository;

    public productService(productRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    public void createProduct(product newProduct) {
        productRepository.save(newProduct);
    }

    public void updateProduct(product updatedProduct) {
        productRepository.save(updatedProduct);
    }

    public void deleteProduct(Integer ID) {
        productRepository.deleteById(ID);
    }
}
