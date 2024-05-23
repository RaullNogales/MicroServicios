package com.mx.mascotas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.mascotas.ClienteFeign.ClienteFeign;
import com.mx.mascotas.entity.ClientesModelo;
import com.mx.mascotas.entity.ResponsablesModelo;
import com.mx.mascotas.model.Mascotas;
import com.mx.mascotas.repository.MascotasRepository;

@Service
@SuppressWarnings("unchecked")
public class MascotasService {

	@Autowired
	MascotasRepository mascDao;
	
	@Autowired
	RestTemplate rtConf;
	
	@Autowired
	ClienteFeign fgCliente;

	public List<Mascotas> listar() {
		List<Mascotas> listaMascotas = new ArrayList<>();
		listaMascotas = mascDao.findAll();
		return listaMascotas;
	}
	

	public String guardar(Mascotas mascotas) {
		if (mascDao.existsById(mascotas.getIdMascota())) {
			return "ID YA EXISTENTE";
		} 
		else {
			List<ClientesModelo> listaClientes =fgCliente.listarC();
			for(ClientesModelo cli : listaClientes) {
				if(mascotas.getIdCliente()==cli.getIdCliente())
				{

					ResponseEntity<List<ResponsablesModelo>> responseEntity = rtConf.exchange("http://localhost:9002/api/responsable/listar",HttpMethod.GET,null,new ParameterizedTypeReference<List<ResponsablesModelo>>() {});
					List<ResponsablesModelo> listaRes = responseEntity.getBody();
					for(ResponsablesModelo res : listaRes) {
						if(mascotas.getIdResponsable()==res.getIdResponsable()) {
							mascDao.save(mascotas);
							return "DATO GUARDADO CON ID "+mascotas.getIdMascota();
						}
					}
					return "NO ES POSIBLE GUARDAR EL REGISTRO YA QUE NO EXISTEN RESPONSABLES CON EL ID "+mascotas.getIdResponsable();
					
				}
			}	
			return "NO ES POSIBLE GUARDAR EL REGISTRO YA QUE NO EXISTEN CLIENTES CON EL ID "+mascotas.getIdCliente();
		}
		
	}
	
	
	public String editar(Mascotas mascotas) {
		if (mascDao.existsById(mascotas.getIdMascota())) {
			mascDao.save(mascotas);
			return "REGISTRO EDITADO";
		} else {
			return "REGISTRO INEXISTENTE PARA EDITAR";
		}
	}

	public Object buscar(Mascotas mascotas) {
		Mascotas buscarMascota = mascDao.findById(mascotas.getIdMascota()).orElse(null);
		if(buscarMascota==null) 
		{
			return "MASCOTA SIN REGISTRO";
		
		}
		else
		{
			return buscarMascota;
		}
		
	}

	public String borrar(Mascotas mascotas) {
		if(mascDao.existsById(mascotas.getIdMascota())) {
			mascDao.delete(mascotas);
			return "DATO BORRADO";
		}
		else {
			return "SIN DATO A BORRAR";
		}
	}
	
	//_-----------------------------
	public List<ClientesModelo> listarC() {
		return fgCliente.listarC();
	}
	
	public ClientesModelo buscarCliente(ClientesModelo cliente) {
		List<ClientesModelo> listaClientes =fgCliente.listarC();
		for(ClientesModelo cli : listaClientes) {
			if(cliente.getIdCliente()==cli.getIdCliente())
			{
				return cli;
			}
		}
		return null;
	}
	
	//---------------
	
	public List<ResponsablesModelo> listarR(){
		return rtConf.getForObject("http://localhost:9002/api/responsable/listar", List.class);
	}
	
	
	
	public ResponsablesModelo buscarR(ResponsablesModelo responsable){
		ResponseEntity<List<ResponsablesModelo>> responseEntity = rtConf.exchange("http://localhost:9002/api/responsable/listar",HttpMethod.GET,null,new ParameterizedTypeReference<List<ResponsablesModelo>>() {});
		List<ResponsablesModelo> listaRes = responseEntity.getBody();
		for(ResponsablesModelo res : listaRes) {
			if(responsable.getIdResponsable()==res.getIdResponsable()) {
				return res;
			}
		}
		return null;
	}


}
