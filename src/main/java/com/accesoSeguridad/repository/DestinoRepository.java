package com.accesoSeguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesoSeguridad.models.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

	

}
