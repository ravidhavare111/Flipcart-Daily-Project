package com.myCompany.FlipcartDailyProject.ControllerTest;

import com.myCompany.FlipcartDailyProject.controller.InventoryController;
import com.myCompany.FlipcartDailyProject.model.Item;
import com.myCompany.FlipcartDailyProject.service.InventoryService;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


//@SpringBootTest
@WebMvcTest(InventoryController.class)
public class inventoryControllerTest {

                        //Spring style testing
    @Autowired
    private MockMvc mock;

    @MockBean
    private InventoryService inventoryService;

    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    public void testHello() throws Exception{
//        mock.perform(get("/inventory/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Good"));
//    }

    @Test
    public void testAddItem() throws Exception {
        Item mockItem = new Item("Amul", "Milk", 36);
        ObjectMapper objMapper = new ObjectMapper();

        mock.perform(post("/inventory/addItem").
                contentType("application/json").
                content(objMapper.writeValueAsString(mockItem)))
                .andExpect(status().isOk())
                .andExpect(content().string("New Item added successfully"));
    }

    @Test
    public void testAddInventory() throws Exception {
        Item mockItem = new Item("Amul","Milk",2);
        ObjectMapper objMapper = new ObjectMapper();

        mock.perform(post("/inventory/addInventory").
                contentType("application/json").
                content(objMapper.writeValueAsString(mockItem)))
                .andExpect(status().isOk());
//                .andExpect(content().string("Inventory added successfully"));
    }

    @Test
    public void testsearchItemsBrands() throws Exception {

        Mockito.when(inventoryService.searchItems("Parle")).
                thenReturn(List.of(new Item("Parle", "CrackJack", 2)));

        Mockito.when(inventoryService.searchItems("Britania")).
                thenReturn(List.of(new Item("Britania", "Buiscuit", 6)));

        Mockito.when(inventoryService.searchItems("Amul")).
                thenReturn(List.of(new Item("Amul", "Milk", 3)));

        Mockito.when(inventoryService.searchItems("Jemini")).
                thenReturn(List.of(new Item("Jemini", "Sunflower Oil", 12)));

        mock.perform(get("/inventory/searchItemsBrands/Britania")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand").value("Britania"));
    }


    @Test
    public void testGetInventorySummary() throws Exception {
        // Arrange: create mock inventory items
        Item item1 = new Item("Parle", "CrackJack", 2);
        Item item2 = new Item("Nestle", "Munch", 5);
        List<Item> itemList = Arrays.asList(item1, item2);

        Mockito.when(inventoryService.getInventorySummary()).thenReturn(itemList);

        // Act & Assert
        mock.perform(get("/inventory/Summary")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand").value("Parle"))
                .andExpect(jsonPath("$[0].category").value("CrackJack"))
                .andExpect(jsonPath("$[0].price").value(2))
                .andExpect(jsonPath("$[1].brand").value("Nestle"))
                .andExpect(jsonPath("$[1].category").value("Munch"))
                .andExpect(jsonPath("$[1].price").value(5));
    }


















                        //Basic testing
//    @Autowired
//    private InventoryController inventoryController;

//    @Test
//    public void testHello(){
////        assertNotNull(inventoryController.hello());
//        assertEquals("Good", inventoryController.hello());
//    }










                            //Sample Testing
//    @ParameterizedTest
//    @CsvSource({
//            "2,4,6",
//            "45,45,90",
//            "3,1,4"
//    })
//    public void testHello(int a, int b, int c){
////        assert(a+b == c);
//        assertEquals(c, a+b);
//    }
}
