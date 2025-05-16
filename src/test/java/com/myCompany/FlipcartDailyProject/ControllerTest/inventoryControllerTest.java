package com.myCompany.FlipcartDailyProject.ControllerTest;

import com.myCompany.FlipcartDailyProject.controller.InventoryController;
import com.myCompany.FlipcartDailyProject.model.Item;
import com.myCompany.FlipcartDailyProject.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;


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
        Item mockItem = new Item("Parle","CrackJack",2);

        mock.perform(get("/inventory/searchItemsBrands/BrandName")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand").value("Parle"))
                .andExpect(jsonPath("$[0].category").value("CrackJack"))
                .andExpect(jsonPath("$[0].quantity").value(2));
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
