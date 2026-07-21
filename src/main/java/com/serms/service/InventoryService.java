package com.serms.service;

import com.serms.entity.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> getAllInventory();

    Inventory saveInventory(Inventory inventory);

    Inventory getInventoryById(Long id);

    Inventory updateInventory(Inventory inventory);

    void deleteInventory(Long id);

    List<Inventory> searchInventory(String keyword);

}