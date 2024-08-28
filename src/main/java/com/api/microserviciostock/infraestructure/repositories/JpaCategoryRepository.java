package com.api.microserviciostock.infraestructure.repositories;


import com.api.microserviciostock.infraestructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
