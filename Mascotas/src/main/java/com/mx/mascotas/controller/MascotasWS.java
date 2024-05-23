package com.mx.mascotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.mascotas.entity.ClientesModelo;
import com.mx.mascotas.entity.ResponsablesModelo;
import com.mx.mascotas.model.Mascotas;
import com.mx.mascotas.service.MascotasService;

@RestController
@RequestMapping("/api/mascotas")
@CrossOrigin
public class MascotasWS {

	@Autowired
	MascotasService mascServ;
	
	@GetMapping("listar")
	public List<Mascotas> listar(){
		return mascServ.listar();
	}
	
	@GetMapping("buscar")
	public Object buscar(@RequestBody Mascotas mascota) {
		return mascServ.buscar(mascota);
	}
	
	@PostMapping("guardar")
	public Object guardar(@RequestBody Mascotas mascotas) {
		return mascServ.guardar(mascotas);
		
	}
	
	@PostMapping("editar")
	public Object editar(@RequestBody Mascotas mascotas) {
		return mascServ.editar(mascotas);
		
	}
	
	@PostMapping("eliminar")
	public Object borrar(@RequestBody Mascotas mascotas) {
		return mascServ.borrar(mascotas);
		
	}
	
	//_-----------------------
	@GetMapping("cliListar")
	public List<ClientesModelo> listarCliente() {
		return mascServ.listarC();
	}
	
	@GetMapping("cliBuscar")
	public ClientesModelo buscarCliente(@RequestBody ClientesModelo cliente) {
		return mascServ.buscarCliente(cliente);
	}
	
	//------------------
	
	@GetMapping("resListar")
	public List<ResponsablesModelo> listarResponsables(){
		return mascServ.listarR();
	}
	
	@GetMapping("resBuscar")
	public ResponsablesModelo buscarRes(@RequestBody ResponsablesModelo mascotas) {
		return mascServ.buscarR(mascotas);
	}
}
