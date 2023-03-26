package com.accesoSeguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesoSeguridad.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
