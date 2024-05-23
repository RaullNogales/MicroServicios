package com.mx.responsables.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.responsable.entity.Veterinaria;

@FeignClient(name="VETERINARIA", url="http://localhost:9003",path="api/veterinaria")
public interface VeterinariaFeign {
	
	@GetMapping("listar")
	public List<Veterinaria> listar();
}
