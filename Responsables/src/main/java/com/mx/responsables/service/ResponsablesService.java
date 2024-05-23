package com.mx.responsables.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.responsable.entity.Veterinaria;
import com.mx.responsables.feignClient.VeterinariaFeign;
import com.mx.responsables.model.Responsable;
import com.mx.responsables.repository.ResponsablesRepository;

@Service
public class ResponsablesService {

	@Autowired
	ResponsablesRepository resDao;
	
	@Autowired
	VeterinariaFeign fgVet;
	
	public List<Responsable> listar(){
		return resDao.findAll();
	}
	
	public Object buscar(@RequestBody Responsable responsable) {
		if(resDao.existsById(responsable.getIdResponsable()))
		{
			return resDao.findById(responsable.getIdResponsable()).orElse(null);
		}
		return "NO HAY DATOS CON ESE VALOR";
	}
	
	public Object guardar(@RequestBody Responsable responsable) {
		if(resDao.existsById(responsable.getIdResponsable())) {
			return "ID YA EXISTENTE";
		}
		else {
			
			
			List<Veterinaria> listaV = fgVet.listar();
			for(Veterinaria vet : listaV) {
				if(responsable.getIdVeterinaria()==vet.getIdVeterinaria()) {
					resDao.save(responsable);
					return "REGISTRO GUARDADO CON EL ID "+responsable.getIdResponsable();
				}
			}
			
			return "NO SE PUEDE GUARDAR EL REGISTRO DADO QUE NO EXISTE UNA VETERINARIA CON ESE ID";
		}	
	}
	
	public Object editar(@RequestBody Responsable responsable) {
		if(!resDao.existsById(responsable.getIdResponsable())) {
			return "NO HAY REGISTRO A EDITAR";
		}
		else {
			resDao.save(responsable);
			return "REGISTRO EDITADO CON EL ID "+responsable.getIdResponsable();
		}	
	}
	
	public String eliminar(Responsable responsable) {
		if(resDao.existsById(responsable.getIdResponsable())) {
			resDao.delete(responsable);
			return "DATO CON ID "+responsable.getIdResponsable()+" ELIMINADO";
		}
		else
			return "SIN REGISTRO EXISTENTE";
	}
	
	
	//_-------------------
	
		public List<Veterinaria> listarV(){
			return fgVet.listar();
		}
		
		public Veterinaria buscarV(Responsable res){
			List<Veterinaria> listaV = fgVet.listar();
			for(Veterinaria vet : listaV) {
				if(res.getIdVeterinaria()==vet.getIdVeterinaria()) {
					return vet;
				}
			}
			return null;
		}
	
	
}
