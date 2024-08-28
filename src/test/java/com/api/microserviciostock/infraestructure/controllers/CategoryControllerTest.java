package com.api.microserviciostock.infraestructure.controllers;

import com.api.microserviciostock.application.service.CategoryService;
import com.api.microserviciostock.domain.Exceptions.CategoryValidationException;
import com.api.microserviciostock.domain.Exceptions.MensajeResponse;
import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class CategoryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    @Test
    void whenValidCategory_thenReturnSuccess() throws Exception {
        Category category = new Category();
        category.setNombre_categoria("Electronics");
        category.setDescripcion_categoria("Electronic items");

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId_categoria(1);
        categoryEntity.setNombre_categoria("Electronics");
        categoryEntity.setDescripcion_categoria("Electronic items");

        when(categoryService.createCategory(category)).thenReturn(categoryEntity);

        mockMvc.perform(post("/api/categoria")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre_categoria\": \"Electronics\", \"descripcion_categoria\": \"Electronic items\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.mensaje").value("Guardado Correctamente"))
                .andExpect(jsonPath("$.object.id_categoria").value(1))
                .andExpect(jsonPath("$.object.nombre_categoria").value("Electronics"))
                .andExpect(jsonPath("$.object.descripcion_categoria").value("Electronic items"));
    }

    @Test
    void whenInvalidCategory_thenReturnBadRequest() throws Exception {
        when(categoryService.createCategory(null)).thenThrow(new CategoryValidationException("Invalid category"));

        mockMvc.perform(post("/api/categoria")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre_categoria\": null, \"descripcion_categoria\": \"Electronic items\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.mensaje").value("Invalid category"));
    }
}

