package com.api.microserviciostock.infraestructure.adapters;

import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.domain.port.output.CategoryRepositoryPort;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;
import com.api.microserviciostock.infraestructure.repositories.JpaCategoryRepository;
import org.springframework.stereotype.Component;


@Component
public class JpaCategoryRepositoryAdapter implements CategoryRepositoryPort {

    private  JpaCategoryRepository jpaCategoryRepository;

    public JpaCategoryRepositoryAdapter(JpaCategoryRepository jpaTaskRepository) {
        this.jpaCategoryRepository = jpaTaskRepository;
    }

    @Override
    public CategoryEntity save(Category category) {
        CategoryEntity categoryEntity =  new CategoryEntity();

        categoryEntity.setNombre_categoria(category.getNombre_categoria());
        categoryEntity.setDescripcion_categoria(category.getDescripcion_categoria());
        return jpaCategoryRepository.save(categoryEntity);
    }
}
