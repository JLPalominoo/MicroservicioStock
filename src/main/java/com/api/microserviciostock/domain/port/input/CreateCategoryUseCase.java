package com.api.microserviciostock.domain.port.input;

import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;

public interface CreateCategoryUseCase {
    CategoryEntity createCategory(Category category);
}
