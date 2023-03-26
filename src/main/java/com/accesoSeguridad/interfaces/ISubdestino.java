package com.accesoSeguridad.interfaces;

import java.util.List;
import java.util.Optional;

import com.accesoSeguridad.models.Destino;
import com.accesoSeguridad.models.SubDestino;

public interface ISubdestino {

	int guardarSubdestino(SubDestino subDestino);
	
	List<SubDestino> listarSubDestino();
	
	Optional<SubDestino>listarSubDestinoId(Long id);
	
	List<SubDestino> prueba(String nombre);
	
}
