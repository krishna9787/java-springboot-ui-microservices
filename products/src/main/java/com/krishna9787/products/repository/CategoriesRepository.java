package com.krishna9787.products.repository;

import com.krishna9787.products.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

    Optional<Categories> findByCategoryName(String categoryName);
}
