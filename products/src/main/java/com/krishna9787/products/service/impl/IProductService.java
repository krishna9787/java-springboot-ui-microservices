package com.krishna9787.products.service.impl;

import com.krishna9787.products.dto.ProductsDto;
import com.krishna9787.products.entity.Products;
import com.krishna9787.products.exception.ProductNotFoundException;
import com.krishna9787.products.mapper.ProductsMapper;
import com.krishna9787.products.repository.ProductsRepository;
import com.krishna9787.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IProductService implements ProductService {

    private ProductsRepository productsRepository;

    @Override
    public List<ProductsDto> findAllProducts(int pageNo, int pageSize) {
        var paegable = PageRequest.of(pageNo, pageSize);
        Page<Products> page = productsRepository.findAll(paegable);
        List<Products> products = page.getContent();
        List<ProductsDto> productsDtos = new ArrayList<>();
        for (var product: products)
            productsDtos.add(ProductsMapper.mapToProductsDto(product, new ProductsDto()));
        return productsDtos;
    }

    @Override
    public void addProduct(ProductsDto productsDto) {
        Products products = ProductsMapper.mapToProducts(productsDto, new Products());
        System.out.println(products.getSku());
        productsRepository.save(products);
    }

    @Override
    public void updateProduct(ProductsDto productsDto) {
        Products products = productsRepository.findBySku(productsDto.getSku()).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        products = ProductsMapper.mapToProducts(productsDto, products);
        productsRepository.save(products);
    }

    @Override
    public void deleteProduct(String sku) {
        Products products = productsRepository.findBySku(sku).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        productsRepository.delete(products);
    }

    @Override
    public void addMultipleProducts(List<ProductsDto> productsDtos) {
        for (ProductsDto productsDto: productsDtos) {
            Products product = ProductsMapper.mapToProducts(productsDto, new Products());
            productsRepository.save(product);
        }
    }


}
