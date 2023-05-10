package com.project.pr.services;

import com.project.pr.enums.requestStatus;
import com.project.pr.models.stockRequest;
import com.project.pr.models.warehouse;
import com.project.pr.models.warehouseProduct;
import com.project.pr.repositories.stockRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class stockRequestService {

    private final stockRequestRepository stockRequestRepository;

    public stockRequestService(stockRequestRepository stockRequestRepository) {
        this.stockRequestRepository = stockRequestRepository;
    }


    public List<stockRequest> getAllStockRequests() {
        return stockRequestRepository.findAll();
    }

    public stockRequest getStockRequestById(Integer ID) {
        return stockRequestRepository.findById(ID).orElse(null);
    }


    public stockRequest createStockRequest(stockRequest newStockRequest) {
        if (stockRequestRepository.existsByWarehouseAndProductAndUser(newStockRequest.getWarehouse(), newStockRequest.getProduct(),newStockRequest.getUser())) {
            return null;
        } else {
            return stockRequestRepository.save(newStockRequest);
        }
    }

    public stockRequest updateRequestQuantity(Integer requestId, Integer quantity) {
        Optional<stockRequest> optionalRequest = stockRequestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            stockRequest stockRequest = optionalRequest.get();
            stockRequest.setQuantity(quantity);
            return stockRequestRepository.save(stockRequest);
        } else {
            return null;
        }
    }

    public void updateRequestStatus(Integer requestId, requestStatus status) {
        Optional<stockRequest> optionalRequest = stockRequestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            stockRequest stockRequest = optionalRequest.get();
            stockRequest.setStatus(status);
            stockRequestRepository.save(stockRequest);
        } else {
            throw new EntityNotFoundException("Stock request with ID " + requestId + " not found");
        }
    }

    public void deleteStockRequest(Integer ID) {
        stockRequestRepository.deleteById(ID);
    }
}

