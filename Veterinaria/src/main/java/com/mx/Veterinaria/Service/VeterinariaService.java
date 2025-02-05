package com.mx.Veterinaria.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Veterinaria.model.Veterinaria;
import com.mx.Veterinaria.repository.VeterinariaRepository;

@Service
public class VeterinariaService {

	@Autowired
	VeterinariaRepository vetDao;

	public List<Veterinaria> listar() {
		return vetDao.findAll();
	}

	public Object buscar(Veterinaria veterinaria) {
		if (vetDao.existsById(veterinaria.getIdVeterinaria())) {
			return vetDao.findById(veterinaria.getIdVeterinaria());
		} else
			return "NO HAY REGISTRO CON ESE ID";
	}

	public String guardar(@RequestBody Veterinaria veterinaria) {
		if (vetDao.existsById(veterinaria.getIdVeterinaria()))
		{
			return "ID YA EXISTENTE";
		}
		else {
			vetDao.save(veterinaria);
			return "REGISTRO GUARDADO CON EL ID " + veterinaria.getIdVeterinaria();
		}
	}

	public Object editar(@RequestBody Veterinaria veterinaria) {
		if (!vetDao.existsById(veterinaria.getIdVeterinaria()))
			return "NO HAY REGISTRO PARA EDITAR";
		else {
			vetDao.save(veterinaria);
			return "REGISTRO EDITADO CON EL ID " + veterinaria.getIdVeterinaria();
		}
	}

	public String eliminar(@RequestBody Veterinaria veterinaria) {
		if (vetDao.existsById(veterinaria.getIdVeterinaria())) {
			vetDao.delete(veterinaria);
			return "REGISTRO ELIMINADO";
		}

		else {
			return "NO HAY REGISTRO";
		}
	}

}
