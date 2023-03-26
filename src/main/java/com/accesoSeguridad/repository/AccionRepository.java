package com.accesoSeguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesoSeguridad.models.Accion;

public interface AccionRepository extends JpaRepository<Accion, Long>{

}
