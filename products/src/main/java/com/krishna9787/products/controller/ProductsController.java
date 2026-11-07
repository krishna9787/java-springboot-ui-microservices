package com.krishna9787.products.controller;

import com.krishna9787.products.dto.ProductsDto;
import com.krishna9787.products.dto.ResponseDto;
import com.krishna9787.products.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api" , produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductsController {

    private ProductService productService;

    @Operation(
            summary = "API to Retrieve all Products",
            description = "API to retrieve all Products based on page number and page size"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @GetMapping(path = "/products")
    public ResponseEntity<List<ProductsDto>> getAllProducts(@RequestParam(value = "pageNo", required=true) int pageNo, @RequestParam(value = "pageSize", required = true) int pageSize ) {
        List<ProductsDto> productsDtos = productService.findAllProducts(pageNo, pageSize);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productsDtos);
    }

    @Operation(
            summary = "API to Add a Product",
            description = "API to add a Product"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP STATUS BAD REQUEST"
            )
    })
    @PostMapping(path = "/product")
    public ResponseEntity<ResponseDto> addAProduct(@RequestBody ProductsDto productsDto) {
        productService.addProduct(productsDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED, "Product added successfully"));

    }

    @Operation(
            summary = "API to update a Product",
            description = "API to update a Product"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status OK"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status Bad Request"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal Server Error"
            )
    })
    @PutMapping(path = "/product")
    public ResponseEntity<ResponseDto> updateProduct(@RequestBody ProductsDto productsDto) {
        productService.updateProduct(productsDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Product updated successfully"));
    }

    @DeleteMapping(path = "/product/{sku}")
    public ResponseEntity<ResponseDto> deleteProduct(@PathVariable String sku) {
        productService.deleteProduct(sku);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Product deleted successfully"));
    }

    @PostMapping("/products")
    public ResponseEntity<ResponseDto> addMultiplePrpducts(@RequestBody List<ProductsDto> productsDtos) {
        productService.addMultipleProducts(productsDtos);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED, "Product added successfully"));
    }
}
