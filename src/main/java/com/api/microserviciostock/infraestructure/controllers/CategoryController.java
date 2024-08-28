package com.api.microserviciostock.infraestructure.controllers;

import com.api.microserviciostock.application.service.CategoryService;
import com.api.microserviciostock.domain.Exceptions.MensajeResponse;
import com.api.microserviciostock.domain.model.Category;
import com.api.microserviciostock.infraestructure.entity.CategoryEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Crear una nueva categoría", description = "Crea una nueva categoría en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoría creada correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/categoria")
    public ResponseEntity<MensajeResponse> create(@RequestBody Category category) {
        MensajeResponse mensajeResponse = new MensajeResponse();

        try {
            CategoryEntity categorySave = categoryService.createCategory(category);
            category.setId_categoria(categorySave.getId_categoria());
            category.setNombre_categoria(categorySave.getNombre_categoria());
            category.setDescripcion_categoria(categorySave.getDescripcion_categoria());

            mensajeResponse.setMensaje("Guardado Correctamente");
            mensajeResponse.setObject(category);
            return new ResponseEntity<>(mensajeResponse, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            mensajeResponse.setMensaje(e.getMessage());
            mensajeResponse.setObject(null);
            return new ResponseEntity<>(mensajeResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


