package com.api.microserviciostock.infraestructure.config;


import com.api.microserviciostock.application.service.CategoryService;
import com.api.microserviciostock.application.usecase.CreateCategoryUseCaseImpl;
import com.api.microserviciostock.domain.port.output.CategoryRepositoryPort;
import com.api.microserviciostock.infraestructure.adapters.JpaCategoryRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class CategoryConfig {

    @Bean
    public CategoryService categoryService(CategoryRepositoryPort categoryRepositoryPort){
    return new CategoryService(new CreateCategoryUseCaseImpl(categoryRepositoryPort));
    }
    @Bean
    public CategoryRepositoryPort categoryRepositoryPort(JpaCategoryRepositoryAdapter jpaCategoryRepositoryAdapter){
    return jpaCategoryRepositoryAdapter;
    }


}
