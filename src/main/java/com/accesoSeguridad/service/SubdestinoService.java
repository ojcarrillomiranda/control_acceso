package com.accesoSeguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesoSeguridad.interfaces.ISubdestino;
import com.accesoSeguridad.models.SubDestino;
import com.accesoSeguridad.repository.SubdestinoRepository;

@Service
public class SubdestinoService implements ISubdestino {
	
	@Autowired
	SubdestinoRepository subdestino;

	@Override
	public int guardarSubdestino(SubDestino subDestino) {
		int res = 0;
		SubDestino sd = subdestino.save(subDestino);
		if (!sd.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public List<SubDestino> listarSubDestino() {
		return subdestino.findAll();
	}

	@Override
	public Optional<SubDestino> listarSubDestinoId(Long id) {
		// TODO Auto-generated method stub
		return subdestino.findById(id); 
	}

	@Override
	public List<SubDestino> prueba(String nombre) {
		// TODO Auto-generated method stub
		return subdestino.findByDestino_destinoNombre(nombre);
	}

	






}
