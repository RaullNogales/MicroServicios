package com.mx.mascotas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientesModelo {

	int IdCliente;
	String nombre;
	String direccion;
	long contacto;
}
