package com.api.microserviciostock.application.service;

import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.domain.port.input.CreateCategoryUseCase;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    @Mock
    private CreateCategoryUseCase createCategoryUseCase;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenCreateCategory_thenReturnCategoryEntity() {
        Category category = new Category();
        category.setNombre_categoria("Clothing");
        category.setDescripcion_categoria("Apparel and accessories");

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId_categoria(1);
        categoryEntity.setNombre_categoria("Clothing");
        categoryEntity.setDescripcion_categoria("Apparel and accessories");

        when(createCategoryUseCase.createCategory(category)).thenReturn(categoryEntity);

        CategoryEntity savedCategoryEntity = categoryService.createCategory(category);

        assertEquals(1, savedCategoryEntity.getId_categoria());
        assertEquals("Clothing", savedCategoryEntity.getNombre_categoria());
        assertEquals("Apparel and accessories", savedCategoryEntity.getDescripcion_categoria());
    }
}

