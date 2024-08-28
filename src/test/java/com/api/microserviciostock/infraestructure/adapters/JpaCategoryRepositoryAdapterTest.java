package com.api.microserviciostock.infraestructure.adapters;

import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.domain.port.output.CategoryRepositoryPort;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;
import com.api.microserviciostock.infraestructure.repositories.JpaCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JpaCategoryRepositoryAdapterTest {

    @Mock
    private JpaCategoryRepository jpaCategoryRepository;

    @InjectMocks
    private JpaCategoryRepositoryAdapter jpaCategoryRepositoryAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenSaveCategory_thenReturnCategoryEntity() {
        Category category = new Category();
        category.setNombre_categoria("Books");
        category.setDescripcion_categoria("Various kinds of books");

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId_categoria(1);
        categoryEntity.setNombre_categoria("Books");
        categoryEntity.setDescripcion_categoria("Various kinds of books");

        when(jpaCategoryRepository.save(categoryEntity)).thenReturn(categoryEntity);

        CategoryEntity savedCategoryEntity = jpaCategoryRepositoryAdapter.save(category);

        assertEquals(1, savedCategoryEntity.getId_categoria());
        assertEquals("Books", savedCategoryEntity.getNombre_categoria());
        assertEquals("Various kinds of books", savedCategoryEntity.getDescripcion_categoria());
    }
}
