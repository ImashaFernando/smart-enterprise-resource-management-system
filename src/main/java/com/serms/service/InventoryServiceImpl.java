package com.serms.service;

import com.serms.entity.Inventory;
import com.serms.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public List<Inventory> searchInventory(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return inventoryRepository.findAll();
        }

        return inventoryRepository
                .findByProductCodeContainingIgnoreCaseOrProductNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrSupplierContainingIgnoreCase(
                        keyword,
                        keyword,
                        keyword,
                        keyword
                );
    }
}