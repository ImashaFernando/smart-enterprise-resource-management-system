package com.serms.repository;

import com.serms.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findByProductCodeContainingIgnoreCaseOrProductNameContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrSupplierContainingIgnoreCase(
            String productCode,
            String productName,
            String category,
            String supplier
    );

}