package com.accesoSeguridad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesoSeguridad.models.Acceso;

@Repository
public interface AccesoRepository extends JpaRepository<Acceso, Long>{
	
	public Optional<Acceso  > findByAccesoCodigo(Long accesoCodigo);
	
	

}
