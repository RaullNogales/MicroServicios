package com.mx.Veterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Veterinaria.model.Veterinaria;

@Repository
public interface VeterinariaRepository extends JpaRepository<Veterinaria, Integer>{

	
}
