package com.mx.Clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Clientes.model.Clientes;
import com.mx.Clientes.service.ClientesService;

@RestController
@RequestMapping("api/clientes")
@CrossOrigin
public class ClientesWS {

	
	@Autowired
	ClientesService cliServ;
	
	@GetMapping("listar")
	public List<Clientes> listar(){
		return cliServ.listar();
	}
	
	@GetMapping("buscar")
	public Object buscar(@RequestBody Clientes clientes) {
		return cliServ.buscar(clientes);
	}
	
	@PostMapping("guardar")
	public Object guardar(@RequestBody Clientes clientes) {
		return cliServ.guardar(clientes);
	}
	
	@PostMapping("editar")
	public Object editar(@RequestBody Clientes clientes) {
		return cliServ.editar(clientes);
	}
	
	@PostMapping("eliminar")
	public Object eliminar(@RequestBody Clientes clientes) {
		return cliServ.eliminar(clientes);
	}
	
	
	
}
