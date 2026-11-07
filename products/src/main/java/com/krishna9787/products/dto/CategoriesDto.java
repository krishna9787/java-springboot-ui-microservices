package com.krishna9787.products.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name="Categories",
        description = "Schema to hold Category details for the products"
)
public class CategoriesDto {

    private int parentCategoryId;

    @Size(max=100)
    private String categoryName;
}
