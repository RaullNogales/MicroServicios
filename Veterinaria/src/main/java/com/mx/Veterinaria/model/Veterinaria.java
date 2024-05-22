package com.mx.Veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="VETERINARIA")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Veterinaria {

	@Id
	int IdVeterinaria;
	String nombre;
	String direccion;
	long telefono;
	
	
	
}


