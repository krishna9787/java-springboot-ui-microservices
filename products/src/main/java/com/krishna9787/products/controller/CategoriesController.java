package com.krishna9787.products.controller;

import com.krishna9787.products.dto.CategoriesDto;
import com.krishna9787.products.dto.ResponseDto;

import com.krishna9787.products.service.CatergoriesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Data
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/api")
public class CategoriesController {

    private CatergoriesService catergoriesService;

    @Operation(
            summary = "Categories Rest API for Adding Category",
            description = "REST API for CRUD operations for Categories feature"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status Created"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status Bad Request"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status Internal Server Error"
            )
    })
    @PostMapping(path="/category")
    public ResponseEntity<ResponseDto> addCategory(@RequestBody CategoriesDto categoriesDto) {
        catergoriesService.addCategories(categoriesDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(HttpStatus.CREATED, "Category created successfully"));
    }


    @GetMapping(path="/categories")
    public ResponseEntity<List<CategoriesDto>> getCategories() {
        List<CategoriesDto> categoriesDtos = catergoriesService.getCategories();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoriesDtos);
    }

    @PutMapping("/category")
    public ResponseEntity<ResponseDto> updateCategory(@RequestBody CategoriesDto categoriesDto) {
        catergoriesService.updateCategory(categoriesDto);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDto(HttpStatus.OK, "Category updated successfully"));
    }

    @DeleteMapping("/category/{categoryName}")
    public ResponseEntity<ResponseDto> deleteCategory(@PathVariable String categoryName) {
        catergoriesService.deleteCategory(categoryName);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(HttpStatus.OK, "Caategory deleted successfully"));
    }
}
