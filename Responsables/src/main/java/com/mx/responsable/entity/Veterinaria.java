package com.mx.responsable.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veterinaria {
	int IdVeterinaria;
	String nombre;
	String direccion;
	long telefono;
	
}
