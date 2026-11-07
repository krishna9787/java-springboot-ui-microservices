package com.krishna9787.products.mapper;

import com.krishna9787.products.dto.CategoriesDto;
import com.krishna9787.products.entity.Categories;

public class CategoriesMapper {

    public static CategoriesDto mapToCategoriesDto(Categories categories, CategoriesDto categoriesDto) {
        categoriesDto.setCategoryName(categories.getCategoryName());
        categoriesDto.setParentCategoryId(categories.getParentCategoryId());

        return categoriesDto;
    }

    public static Categories mapToCategories(CategoriesDto categoriesDto, Categories categories) {
        categories.setCategoryName(categories.getCategoryName());
        categories.setParentCategoryId(categories.getParentCategoryId());

        return categories;
    }
}
