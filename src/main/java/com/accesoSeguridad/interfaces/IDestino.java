package com.accesoSeguridad.interfaces;

import java.util.List;
import java.util.Optional;

import com.accesoSeguridad.models.Color;
import com.accesoSeguridad.models.Destino;

public interface IDestino {
	List<Destino> listarDestino();
	Optional<Destino>listarDestinoId(Long id);
	int save(Destino destino);
	List<Color>listarColores();
	
}
