package com.accesoSeguridad.interfaces;

import java.util.List;
import java.util.Optional;

import com.accesoSeguridad.models.Acceso;
import com.accesoSeguridad.models.Accion;
import com.accesoSeguridad.models.Ciudad;

public interface IAcceso {
	
	List<Acceso>listarAccesos();
	 
	
	
	
	Optional<Acceso>listarId(Long accesoCodigo);
	int save(Acceso acceso);
	Long contador();
	
	List<Ciudad> listarCiudades();
	List<Accion> listarAcciones();
	

	
	
}
