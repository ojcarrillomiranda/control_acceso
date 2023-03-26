package com.accesoSeguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesoSeguridad.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	

}
