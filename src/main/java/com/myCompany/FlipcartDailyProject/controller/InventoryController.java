package com.myCompany.FlipcartDailyProject.controller;

import com.myCompany.FlipcartDailyProject.model.Item;
import com.myCompany.FlipcartDailyProject.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/hello")
    public String hello(){
        return "Good";
    }


    //addItem is for us
    @PostMapping("/addItem")
    public String addItems(@RequestBody Item addItemObject){
        inventoryService.addItem(addItemObject);
        return "New Item added successfully";
    }


    // addInventory is for customer
    @PostMapping("/addInventory")
    public String addInventory(@RequestBody Item addInventoryObject) {
        return inventoryService.addInventory(addInventoryObject);
    }


    @GetMapping("/searchItemsBrands/{BrandName}")
    public List<Item> searchItemsBrands(@PathVariable String BrandName) {
        return inventoryService.searchItems(BrandName);
    }

    @GetMapping("/Summary")
    public List<Item> searchItemsBrands() {
        return inventoryService.getInventorySummary();
    }
}