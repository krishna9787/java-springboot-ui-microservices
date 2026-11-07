package com.krishna9787.products.service;

import com.krishna9787.products.dto.ProductsDto;
import com.krishna9787.products.dto.ResponseDto;

import java.util.List;

public interface ProductService {

    List<ProductsDto> findAllProducts(int pageNo, int pageSize);

    void addProduct(ProductsDto productsDto);

    void updateProduct(ProductsDto productsDto);

    void deleteProduct(String sku);

    void addMultipleProducts(List<ProductsDto> productsDtos);
}
