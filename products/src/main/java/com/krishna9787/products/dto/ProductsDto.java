package com.krishna9787.products.dto;

import com.krishna9787.products.entity.*;
import com.krishna9787.products.util.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name="Products",
        description = "Schema to store Product data"
)
public class ProductsDto {

    @NotNull(message = "SKU field cannot be null")
    private String sku;

    private String name;
    private String description;
    private Brands brandId;
    private double basePrice;
    private Status status;
    private Categories categoryId;
    private List<ProductImages> productImagesId = new ArrayList<>();
    private List<ProductVariants> productVariants = new ArrayList();
    private List<Discounts> discounts;
}
