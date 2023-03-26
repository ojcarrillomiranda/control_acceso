package com.accesoSeguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesoSeguridad.interfaces.IDestino;
import com.accesoSeguridad.models.Color;
import com.accesoSeguridad.models.Destino;
import com.accesoSeguridad.repository.ColorRepository;
import com.accesoSeguridad.repository.DestinoRepository;

@Service
public class DestinoService implements IDestino {

	@Autowired
	DestinoRepository data;
	
	@Autowired
	ColorRepository colorRepository;
	
	
	
	@Override
	public List<Destino> listarDestino() {
		return data.findAll();
		
	}

	@Override
	public Optional<Destino> listarDestinoId(Long id) {
		// TODO Auto-generated method stub
		return data.findById(id);
		
	}

	@Override
	public int save(Destino destino) {
		int res = 0;
		Destino d = data.save(destino);
		if (!d.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public List<Color> listarColores() {
		// TODO Auto-generated method stub
		return colorRepository.findAll();
	}




}
