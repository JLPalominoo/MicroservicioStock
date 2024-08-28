package com.api.microserviciostock.application.usecase;

import com.api.microserviciostock.domain.Exceptions.CategoryValidationException;
import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.domain.port.input.CreateCategoryUseCase;
import com.api.microserviciostock.domain.port.output.CategoryRepositoryPort;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;

public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

    private CategoryRepositoryPort categoryRepositoryPort;

    public CreateCategoryUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }


    @Override
    public CategoryEntity createCategory(Category category) {
        if (category.getNombre_categoria() == null || category.getDescripcion_categoria() == null) {
            throw new CategoryValidationException("Nombre y descripción de la categoría son obligatorios.");
        }

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setNombre_categoria(category.getNombre_categoria());
        categoryEntity.setDescripcion_categoria(category.getDescripcion_categoria());

        try {
            return categoryRepositoryPort.save(category);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la categoría", e);
        }
    }
}
