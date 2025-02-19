package com.mx.Clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Clientes.model.Clientes;
import com.mx.Clientes.repository.ClientesRepository;

@Service
public class ClientesService {

	@Autowired
	ClientesRepository cliDao;
	
	public List<Clientes> listar(){
		return cliDao.findAll();
	}
	
	
	public Object buscar(Clientes clientes) {
		if(cliDao.existsById(clientes.getIdCliente()))
		{
			return cliDao.findById(clientes.getIdCliente());
		}
		else
		{
			return "NO HAY DATOS CON ESE REGISTRO";
		}
		
	}
	
	public Object guardar(Clientes clientes) {
		if(cliDao.existsById(clientes.getIdCliente())) {
			return "ID YA REGISTRADO";
		}
		else
		{
			cliDao.save(clientes);
			return "REGISTRO GUARDADO EN EL ID "+clientes.getIdCliente();
		}
	}
	
	public Object editar(Clientes clientes) {
		if(!cliDao.existsById(clientes.getIdCliente())) {
			return "SIN REGISTRO PARA EDITAR";
		}
		else
		{
			cliDao.save(clientes);
			return "REGISTRO EN EL ID "+clientes.getIdCliente()+" AH SIDO EDITADO";
		}
	}
	
	public Object eliminar(Clientes clientes) {
		if(cliDao.existsById(clientes.getIdCliente())) {
			cliDao.delete(clientes);
			return "REGISTRO ELIMINADO";
		}
		else
		{
			return "REGISTRO INEXISTENTE";
		}
	}
	
	
	
}
