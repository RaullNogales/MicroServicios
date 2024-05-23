package com.mx.mascotas.ClienteFeign;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


import com.mx.mascotas.entity.ClientesModelo;

@FeignClient(name="CLIENTES", url="http://localhost:9004",path="api/clientes")
public interface ClienteFeign {

	@GetMapping("listar")
	public List<ClientesModelo> listarC();
	
}
