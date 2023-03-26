package com.accesoSeguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesoSeguridad.interfaces.IFicha;
import com.accesoSeguridad.models.Destino;
import com.accesoSeguridad.models.Ficha;
import com.accesoSeguridad.repository.DestinoRepository;
import com.accesoSeguridad.repository.FichaRepository;


@Service
public class FichaService implements IFicha {

	@Autowired
	private FichaRepository data;
	
	@Autowired
	private DestinoRepository dataDestino;


	@Override
	public Optional<Ficha> listarId(Long id) {
		// TODO Auto-generated method stub
		return data.findById(id);
		
	}


	@Override
	public int save(Ficha ficha) {
		// TODO Auto-generated method stub
		int res = 0;
		Ficha t = data.save(ficha);
		if (!t.equals(null)) {
			res = 1;
		}
		return res;
	}

	

	@Override
	public List<Ficha> listar() {
		// TODO Auto-generated method stub
		return data.findAll();
	}


	@Override
	public List<Destino> listarDestino() {
		// TODO Auto-generated method stub
		return dataDestino.findAll();
	}


}
