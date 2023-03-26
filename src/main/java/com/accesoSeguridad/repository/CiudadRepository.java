package com.accesoSeguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesoSeguridad.models.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long>{

}
