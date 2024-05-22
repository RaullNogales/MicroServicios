package com.mx.responsables.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="RESPONSABLES")
@Data
public class Responsable {

	@Id
	private int idResponsable;
	private String nombre;
	private long contacto;
	private int idVeterinaria;
}
