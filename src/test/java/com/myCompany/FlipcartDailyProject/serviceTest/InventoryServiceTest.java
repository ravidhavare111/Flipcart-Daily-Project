package com.myCompany.FlipcartDailyProject.serviceTest;

import com.myCompany.FlipcartDailyProject.model.Item;
import com.myCompany.FlipcartDailyProject.service.InventoryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class InventoryServiceTest {
    private InventoryService inventoryService;
    @BeforeEach
    void setup(){
        inventoryService = new InventoryService();
    }

    @Test
    void testAddItem(){
        Item item = new Item("Amul", "Milk", 35);
        inventoryService.addItem(item);

        List<Item> itemList = inventoryService.getInventorySummary();
        assertEquals(1, itemList.size());
        assertEquals(item, itemList.get(0));
    }

    @Test
    void testAddInventory(){
        Item addItem = new Item("Samsung", "Oven", 400);
        inventoryService.addItem(addItem);

        Item addInventory = new Item("Samsung", "Oven", 400);
        addInventory.setQuantity(2);
        inventoryService.addInventory(addInventory);

        List<Item> ItemList = inventoryService.getInventorySummary();

        assertEquals(addItem, ItemList.get(0));
        assertEquals("Samsung", ItemList.get(0).getBrand());
        assertEquals("Oven", ItemList.get(0).getCategory());
        assertEquals(400, ItemList.get(0).getPrice());
        assertEquals(2, ItemList.get(0).getQuantity());
    }


    @Test
    void testAddInventory_FailureForNonExistingItem() {
        Item item = new Item("LG", "Fridge", 15000);
        String response = inventoryService.addInventory(item);
        assertEquals("This product is not available, please add 1st in system", response);
    }

    @Test
    void testSearchItemByBrandName(){
        Item item1 = new Item("Sony", "TV", 30000);
        Item item2 = new Item("Samsung", "TV", 25000);
        Item item3 = new Item("Sony", "Speaker", 31000);

        inventoryService.addItem(item1);
        inventoryService.addItem(item2);
        inventoryService.addItem(item3);
        List<Item> itemList = inventoryService.searchItems("Sony");

        assertEquals(item1, itemList.get(0));
        assertEquals(item3, itemList.get(1));
    }

    @Test
    void testGetSummery(){
        Item item1 = new Item("Sony", "TV", 30000);
        Item item2 = new Item("Samsung", "TV", 25000);
        Item item3 = new Item("Sony", "Speaker", 31000);

        inventoryService.addItem(item1);
        inventoryService.addItem(item2);
        inventoryService.addItem(item3);
        List<Item> itemList = inventoryService.getInventorySummary();

        assertEquals(item2, itemList.get(0));
        assertEquals(item1, itemList.get(1));
        assertEquals(item3, itemList.get(2));
    }
}
