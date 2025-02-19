package com.mx.mascotas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="MASCOTA2")
@Data

public class Mascotas {

	@Id
	private int idMascota;
	private String nombre;
	private String raza;
	private int edad;
	@Column(name="RAZON_CITA")
	private String razonCita;
	@Column(name="ID_CLIENTE")
	private int idCliente;
	@Column(name="ID_RESPONSABLE")
	private int idResponsable;
	@Column(name="ID_VETERINARIA")
	private int idVeterinaria;
}   
