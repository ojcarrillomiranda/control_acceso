package com.accesoSeguridad.interfaces;

import java.util.List;
import java.util.Optional;

import com.accesoSeguridad.models.Visitante;

public interface IVisitante {
	List<Visitante>listar(String term);
	List<Visitante> listarTodos();
	Optional<Visitante>listarId(Long visitanteCodigo);
	int save(Visitante visitante);
	void delete(Long visitante);
	Long contador();
}
