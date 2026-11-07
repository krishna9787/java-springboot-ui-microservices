package com.krishna9787.products.mapper;

import com.krishna9787.products.dto.ProductsDto;
import com.krishna9787.products.entity.Categories;
import com.krishna9787.products.entity.Products;

import java.util.ArrayList;

public class ProductsMapper {

    public static ProductsDto mapToProductsDto(Products products, ProductsDto productsDto) {
        productsDto.setName(products.getName());
        productsDto.setSku(products.getSku());
        productsDto.setDescription(products.getDescription());
        productsDto.setBrandId(products.getBrandId());
        productsDto.setBasePrice(products.getBasePrice());
        productsDto.setStatus(products.getStatus());
        productsDto.setCategoryId(products.getCategoryId());
        productsDto.setProductImagesId(products.getProductImagesId());
        productsDto.setProductVariants(products.getProductVariants());
        productsDto.setDiscounts(products.getDiscounts());

        return productsDto;
    }

    public static Products mapToProducts(ProductsDto productsDto, Products products) {
        products.setName(productsDto.getName());
        products.setSku(productsDto.getSku());
        products.setDescription(productsDto.getDescription());
        products.setBrandId(productsDto.getBrandId());
        products.setBasePrice(productsDto.getBasePrice());
        products.setStatus(productsDto.getStatus());
        products.setCategoryId(productsDto.getCategoryId());
        products.setProductImagesId(productsDto.getProductImagesId());
        products.setProductVariants(productsDto.getProductVariants());
        products.setDiscounts(productsDto.getDiscounts());

        return products;
    }
}
