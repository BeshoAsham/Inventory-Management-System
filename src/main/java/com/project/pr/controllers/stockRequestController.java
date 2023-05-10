package com.project.pr.controllers;

import com.project.pr.enums.requestStatus;
import com.project.pr.models.stockRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.pr.services.stockRequestService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stockRequest")
public class stockRequestController {

    private final stockRequestService stockRequestService;

    public stockRequestController(com.project.pr.services.stockRequestService stockRequestService) {
        this.stockRequestService = stockRequestService;
    }

    @PostMapping("/supervisor/create")
    public ResponseEntity<String> createStockRequest(@RequestBody stockRequest newStockRequest) {
        stockRequest stockRequestCheck = stockRequestService.createStockRequest(newStockRequest);
        if (stockRequestCheck == null) {
            return ResponseEntity.badRequest().body("This Stock Request already exists");
        } else {
            return ResponseEntity.ok("The Stock Request is added successfully");
        }
    }


    @GetMapping("/admin/getAll")
    public List<stockRequest> getAllStockRequests() {
        return stockRequestService.getAllStockRequests();
    }

    @GetMapping("/getById")
    public stockRequest getStockRequestById(@RequestParam Integer ID) {
        return stockRequestService.getStockRequestById(ID);

    }

    @PutMapping("/admin/updateStatus/{id}")
    public ResponseEntity<String> updateStockRequestStatus(@PathVariable("id") Integer id, @RequestBody Map<String, String> request) {
        String statusString = request.get("status");
        if (statusString == null) {
            return new ResponseEntity<>("Invalid request body", HttpStatus.BAD_REQUEST);
        }
        requestStatus status = requestStatus.valueOf(statusString);
        stockRequestService.updateRequestStatus(id, status);
        return new ResponseEntity<>("Stock Request status is updated!", HttpStatus.OK);
    }

    @PutMapping("supervisor/updateQuantity/{id}/{Quantity}")
    public ResponseEntity<String> updateStockRequestQuantity(@PathVariable("id") Integer requestId, @PathVariable("Quantity") Integer quantity) {
        stockRequest stockRequestCheck = stockRequestService.updateRequestQuantity(requestId, quantity);
        if (stockRequestCheck == null) {
            return ResponseEntity.badRequest().body("Stock Request not found ");
        } else {
            return ResponseEntity.ok("The Stock Request Quantity is Updated successfully");
        }
    }


    @DeleteMapping("/admin/delete")
    public String deleteStockRequest(@RequestParam Integer ID) {
        stockRequestService.deleteStockRequest(ID);
        return "deleted successfully";
    }
}