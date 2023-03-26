package com.accesoSeguridad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesoSeguridad.models.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {

}
