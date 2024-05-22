package com.mx.Clientes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CLIENTES")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Clientes {

	@Id
	int IdCliente;
	String nombre;
	String direccion;
	long contacto;
}
