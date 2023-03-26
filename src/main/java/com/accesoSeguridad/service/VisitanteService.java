package com.accesoSeguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesoSeguridad.interfaces.IVisitante;
import com.accesoSeguridad.models.Visitante;
import com.accesoSeguridad.repository.VisitanteRepository;



@Service
public class VisitanteService implements IVisitante {

	@Autowired
	private VisitanteRepository data;

	@Override
	public List<Visitante> listar(String term) {

		return data.findByVisitanteIdentificacionContainingIgnoreCase(term);
	}

	@Override
	public Optional<Visitante> listarId(Long visitanteCodigo) {
		// TODO Auto-generated method stub
		return data.findByVisitanteCodigo( visitanteCodigo);
	}


	@Override
	public int save(Visitante v) {
		// TODO Auto-generated method stub
		int res=0;
		Visitante visitante = data.save(v);
		if (!visitante.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(Long visitanteCodigo) {
		// TODO Auto-generated method stub
		data.deleteById(visitanteCodigo);

	}

	@Override
	public Long contador() {
		return data.count();
	}

	@Override
	public List<Visitante> listarTodos() {
		// TODO Auto-generated method stub
		return data.findAll();
	}

}
