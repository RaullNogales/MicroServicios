package com.mx.mascotas.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientesModelo {

	private int IdCliente;
	private String nombre;
	private String direccion;
	private long contacto;
}
