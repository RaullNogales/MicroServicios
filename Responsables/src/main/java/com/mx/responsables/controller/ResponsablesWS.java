package com.mx.responsables.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.responsable.entity.Veterinaria;
import com.mx.responsables.model.Responsable;
import com.mx.responsables.service.ResponsablesService;

@RestController
@RequestMapping("api/responsable")
@CrossOrigin
public class ResponsablesWS {

	@Autowired
	ResponsablesService resServ;
	
	@GetMapping("listar")
	public List<Responsable> listar(){
		return resServ.listar();
	}
	
	@GetMapping("buscar")
	public Object buscar(@RequestBody Responsable responsable) {
		return resServ.buscar(responsable);
	}
	
	@PostMapping("guardar")
	public Object guardar(@RequestBody Responsable responsable) {
		return resServ.guardar(responsable);
	}
	
	@PostMapping("editar")
	public Object editar(@RequestBody Responsable responsable) {
		return resServ.editar(responsable);
	}
	
	@PostMapping("eliminar")
	public String eliminar(@RequestBody Responsable responsable) {
		return resServ.eliminar(responsable);
	}
	
	//_----------
	
	@GetMapping("listarV")
	public List<Veterinaria> listarV(){
		return resServ.listarV();
	}
	
	@GetMapping("buscarV")
	public Veterinaria buscarV(@RequestBody Responsable responsable){
		return resServ.buscarV(responsable);
	}
	
}
