package com.krishna9787.products.service.impl;

import com.krishna9787.products.dto.CategoriesDto;
import com.krishna9787.products.entity.Categories;
import com.krishna9787.products.exception.CategoryNotFound;
import com.krishna9787.products.mapper.CategoriesMapper;
import com.krishna9787.products.repository.CategoriesRepository;
import com.krishna9787.products.service.CatergoriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ICategoriesService implements CatergoriesService {

    private CategoriesRepository categoriesRepository;

    @Override
    public void addCategories(CategoriesDto categoriesDto) {
        Categories categories = CategoriesMapper.mapToCategories(categoriesDto, new Categories());

        categoriesRepository.save(categories);
    }

    @Override
    public List<CategoriesDto> getCategories() {
        List<Categories> categories = categoriesRepository.findAll();
        List<CategoriesDto> categoriesDtos = new ArrayList<>();
        for (Categories category: categories) {
            categoriesDtos.add(CategoriesMapper.mapToCategoriesDto(category, new CategoriesDto()));
        }

        return categoriesDtos;
    }

    @Override
    public void updateCategory(CategoriesDto categoriesDto) {
        Categories categories = categoriesRepository.findByCategoryName(categoriesDto.getCategoryName()).orElseThrow(() -> new CategoryNotFound("Category not found"));

        categories = CategoriesMapper.mapToCategories(categoriesDto, categories);

        categoriesRepository.save(categories);
    }

    @Override
    public void deleteCategory(String categoryName) {
        Categories category = categoriesRepository.findByCategoryName(categoryName).orElseThrow(() -> new CategoryNotFound("Category not found"));

        CategoriesDto categoriesDto = CategoriesMapper.mapToCategoriesDto(category, new CategoriesDto());
    }


}
