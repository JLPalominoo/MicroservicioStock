package com.api.microserviciostock.domain.port.output;

import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;

public interface CategoryRepositoryPort {
    CategoryEntity save(Category category);

}
