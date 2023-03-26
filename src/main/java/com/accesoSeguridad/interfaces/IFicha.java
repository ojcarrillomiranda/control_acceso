package com.accesoSeguridad.interfaces;

import java.util.List;
import java.util.Optional;

import com.accesoSeguridad.models.Destino;
import com.accesoSeguridad.models.Ficha;

public interface IFicha {
	List<Destino>listarDestino();
	List<Ficha>listar();
	Optional<Ficha>listarId(Long id);
	int save(Ficha ficha);
	
	
}


