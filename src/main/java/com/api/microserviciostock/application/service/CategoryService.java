package com.api.microserviciostock.application.service;


import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.domain.port.input.CreateCategoryUseCase;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;

public class CategoryService implements CreateCategoryUseCase {

    private  CreateCategoryUseCase createCategoryUseCase;

    public CategoryService(CreateCategoryUseCase createCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
    }

    @Override
    public CategoryEntity createCategory(Category category) {
        CategoryEntity categoryEntity =  new CategoryEntity();

        categoryEntity.setNombre_categoria(category.getNombre_categoria());
        categoryEntity.setDescripcion_categoria(category.getDescripcion_categoria());
        return createCategoryUseCase.createCategory(category);
    }
}
