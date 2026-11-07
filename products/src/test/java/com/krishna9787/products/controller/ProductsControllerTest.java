package com.krishna9787.products.controller;

import com.krishna9787.products.dto.ProductsDto;
import com.krishna9787.products.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductsControllerTest {

    private MockMvc mockMvc;
    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = mock(ProductService.class);
        ProductsController controller = new ProductsController(productService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllProducts_shouldReturnOkResponseWithProducts() throws Exception {
        ProductsDto product = new ProductsDto();
        product.setSku("SKU-001");
        product.setName("Laptop");

        when(productService.findAllProducts(0, 10)).thenReturn(List.of(product));

        mockMvc.perform(get("/api/products")
                .param("pageNo", "0")
                .param("pageSize", "10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].sku").value("SKU-001"))
                .andExpect(jsonPath("$[0].name").value("Laptop"));
    }
}
