package com.accesoSeguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesoSeguridad.interfaces.IAcceso;
import com.accesoSeguridad.models.Acceso;
import com.accesoSeguridad.models.Accion;
import com.accesoSeguridad.models.Ciudad;
import com.accesoSeguridad.repository.AccesoRepository;
import com.accesoSeguridad.repository.AccionRepository;
import com.accesoSeguridad.repository.CiudadRepository;


@Service
public class AccesoService implements IAcceso {

	@Autowired
	private AccesoRepository data;
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Autowired
	private AccionRepository accionRepository;

	@Override
	public List<Acceso> listarAccesos() {
		// TODO Auto-generated method stub
		return data.findAll();
	}

	@Override
	public Optional<Acceso> listarId(Long accesoCodigo) {
		// TODO Auto-generated method stub
		return data.findById(accesoCodigo);
	}

	@Override
	public int save(Acceso acceso) {
		int res = 0;
		Acceso a = data.save(acceso);
		if (!a.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public Long contador() {
		// TODO Auto-generated method stub
		return data.count();
	}

	@Override
	public List<Ciudad> listarCiudades() {
		// TODO Auto-generated method stub
		return ciudadRepository.findAll();
	}

	@Override
	public List<Accion> listarAcciones() {
		// TODO Auto-generated method stub
		return accionRepository.findAll();
	}

	
	 
	
	
}
