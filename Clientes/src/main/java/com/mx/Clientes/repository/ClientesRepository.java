package com.mx.Clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Clientes.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer>{

}
