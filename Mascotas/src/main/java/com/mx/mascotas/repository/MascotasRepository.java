package com.mx.mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.mascotas.model.Mascotas;

public interface MascotasRepository extends JpaRepository<Mascotas, Integer>{

	
}
