package com.accesoSeguridad.interfaces;

import java.util.List;
import java.util.Optional;

import com.accesoSeguridad.models.Vehiculo;

public interface IVehiculo {
	List<Vehiculo>listar();
	Optional<Vehiculo>listarId(Long vehiculoCodigo);
	int save(Vehiculo vehiculo);
	void delete(Long vehiculoCodigo);
	Long contador();
	List<Vehiculo> listarPlaca(String term);
}
