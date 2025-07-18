package com.myCompany.FlipcartDailyProject.service;

import com.myCompany.FlipcartDailyProject.model.Item;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class InventoryService {
    private Map<String, Item> inventory = new HashMap<String, Item>();

    private String getKey(String brand, String category) {
        return brand + "#" + category;
    }

    public void addItem(Item addItemObject) {
        String key = getKey(addItemObject.getBrand(), addItemObject.getCategory());
        if (!inventory.containsKey(key)) {
            inventory.put(key, addItemObject);
        }
    }

    public String addInventory(Item addInventoryObject) {
        String key = getKey(addInventoryObject.getBrand(), addInventoryObject.getCategory());
        if (inventory.containsKey(key)) {
            inventory.get(key).addQuantity(addInventoryObject.getQuantity());
        }
        else{
            return "This product is not available, please add 1st in system";
        }
        return "Inventory added successfully";
    }



//    public List<Item> searchItems(String BrandName) {
//        List<Item> filteredItems = new ArrayList<>();
//
//        for (Item item : inventory.values()) {
//            if (item.getBrand().equals(BrandName)) {
//                filteredItems.add(item);
//            }
//        }
//        if(filteredItems.isEmpty())
//            return new ArrayList<>();
//        return filteredItems;
//    }


    public List<Item> searchItems(String brandName) {
        return inventory.values().stream()
                .filter(item -> item.getBrand().equalsIgnoreCase(brandName))  // Filter by brand
                .sorted(Comparator.comparingInt(Item::getPrice))  // Sort by price in ascending order
                .collect(Collectors.toList());
    }



//    public List<Item> getInventorySummary() {
//        if(inventory.isEmpty()){
//            return null;
//        }
//        List<Item> AllSummary = new ArrayList<>();
//        AllSummary.addAll(inventory.values());
//        return AllSummary;
//    }

    public List<Item> getInventorySummary() {
        return inventory.values().stream()
                .sorted(Comparator.comparingInt(Item::getPrice)) // sort by price ascending
                .collect(Collectors.toList());
    }
}
