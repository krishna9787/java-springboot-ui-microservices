package com.krishna9787.products.repository;

import com.krishna9787.products.dto.ProductsDto;
import com.krishna9787.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Long> {

//    @Query("SELECT p from Products p where p.name LIKE CONCAT('%', :query, '%') OR p.brandId LIKE CONCAT('%', :query, '%')")
//    public List<Products> searchProducts(String query);

    public Optional<Products> findBySku(String sku);
}
