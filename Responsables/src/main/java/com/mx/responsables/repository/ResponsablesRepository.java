package com.mx.responsables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.responsables.model.Responsable;

@Repository
public interface ResponsablesRepository extends JpaRepository<Responsable, Integer>{

}
