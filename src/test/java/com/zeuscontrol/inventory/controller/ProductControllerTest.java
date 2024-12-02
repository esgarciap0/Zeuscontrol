package com.zeuscontrol.inventory.controller;

import com.zeuscontrol.inventory.model.Product;
import com.zeuscontrol.inventory.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllProducts_ShouldReturnListOfProducts() throws Exception {
        ProductService mockProductService = Mockito.mock(ProductService.class);
        ProductController productController = new ProductController(mockProductService);

        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

        Product product1 = new Product(1L, "Product 1", "Description 1", 100.0, 10);
        Product product2 = new Product(2L, "Product 2", "Description 2", 200.0, 20);

        when(mockProductService.getAllProducts()).thenReturn(Arrays.asList(product1, product2));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Product 1"));
    }
}

