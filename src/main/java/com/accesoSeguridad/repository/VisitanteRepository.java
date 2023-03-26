package com.accesoSeguridad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesoSeguridad.models.Visitante;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long>{

	public List<Visitante> findByVisitanteIdentificacionContainingIgnoreCase(String term);

	public Optional<Visitante> findByVisitanteCodigo(Long visitanteCodigo);


}
