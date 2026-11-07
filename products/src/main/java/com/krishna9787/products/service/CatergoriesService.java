package com.krishna9787.products.service;

import com.krishna9787.products.dto.CategoriesDto;
import java.util.List;

public interface CatergoriesService {
    void addCategories(CategoriesDto categoriesDto);

    List<CategoriesDto> getCategories();

    void updateCategory(CategoriesDto categoriesDto);

    void deleteCategory(String categoryName);
}
