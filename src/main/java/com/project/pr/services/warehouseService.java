package com.project.pr.services;

import com.project.pr.models.warehouse;
import org.springframework.stereotype.Service;
import com.project.pr.repositories.warehouseRepository;
import java.util.List;

@Service
public class warehouseService {

    private final warehouseRepository warehouseRepository;

    public warehouseService(warehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }



    public List<warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    public void createWarehouse(warehouse newWarehouse) {
        warehouseRepository.save(newWarehouse);
    }

    public void updateWarehouse(warehouse updatedWarehouse) {
        warehouseRepository.save(updatedWarehouse);
    }

    public void deleteWarehouse(Integer ID) {
        warehouseRepository.deleteById(ID);
    }
}
