package com.mx.mascotas.entity;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
public class ResponsablesModelo {

	private int idResponsable;
	private String nombre;
	private long contacto;
	private int idVeterinaria;
	public int getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getContacto() {
		return contacto;
	}
	public void setContacto(long contacto) {
		this.contacto = contacto;
	}
	public int getIdVeterinaria() {
		return idVeterinaria;
	}
	public void setIdVeterinaria(int idVeterinaria) {
		this.idVeterinaria = idVeterinaria;
	}
	
	
}
