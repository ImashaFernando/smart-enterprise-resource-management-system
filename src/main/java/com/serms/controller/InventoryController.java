package com.serms.controller;

import com.serms.entity.Inventory;
import com.serms.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public String listInventory(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model) {

        model.addAttribute("inventoryList",
                inventoryService.searchInventory(keyword));

        model.addAttribute("keyword", keyword);

        return "inventory";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        model.addAttribute("inventory", new Inventory());

        return "inventory-add";
    }

    @PostMapping("/save")
    public String saveInventory(@ModelAttribute Inventory inventory) {

        inventoryService.saveInventory(inventory);

        return "redirect:/inventory";
    }

    @GetMapping("/edit/{id}")
    public String editInventory(@PathVariable Long id, Model model) {

        model.addAttribute("inventory",
                inventoryService.getInventoryById(id));

        return "inventory-edit";
    }

    @PostMapping("/update/{id}")
    public String updateInventory(@PathVariable Long id,
                                  @ModelAttribute Inventory inventory) {

        inventory.setId(id);

        inventoryService.updateInventory(inventory);

        return "redirect:/inventory";
    }

    @GetMapping("/delete/{id}")
    public String deleteInventory(@PathVariable Long id) {

        inventoryService.deleteInventory(id);

        return "redirect:/inventory";
    }
}