package com.accesoSeguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesoSeguridad.models.SubDestino;

@Repository
public interface SubdestinoRepository extends JpaRepository<SubDestino, Long> {
	
	List<SubDestino>findByDestino_destinoNombre(String nombre);

}
