package com.api.microserviciostock.application.usecase;

import com.api.microserviciostock.domain.Exceptions.CategoryValidationException;
import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.domain.port.output.CategoryRepositoryPort;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class CreateCategoryUseCaseImplTest {

    @Mock
    private CategoryRepositoryPort categoryRepositoryPort;

    @InjectMocks
    private CreateCategoryUseCaseImpl createCategoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenCategoryIsValid_thenSaveCategory() {
        Category category = new Category();
        category.setNombre_categoria("Electronics");
        category.setDescripcion_categoria("Electronic items");

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId_categoria(1);
        categoryEntity.setNombre_categoria("Electronics");
        categoryEntity.setDescripcion_categoria("Electronic items");

        when(categoryRepositoryPort.save(category)).thenReturn(categoryEntity);

        CategoryEntity savedCategory = createCategoryUseCase.createCategory(category);

        assertEquals(1, savedCategory.getId_categoria());
        assertEquals("Electronics", savedCategory.getNombre_categoria());
        assertEquals("Electronic items", savedCategory.getDescripcion_categoria());
    }

    @Test
    void whenCategoryIsInvalid_thenThrowCategoryValidationException() {
        Category invalidCategory = new Category();
        invalidCategory.setNombre_categoria(null); // or any other invalid state

        assertThrows(CategoryValidationException.class, () -> {
            createCategoryUseCase.createCategory(invalidCategory);
        });
    }
}

