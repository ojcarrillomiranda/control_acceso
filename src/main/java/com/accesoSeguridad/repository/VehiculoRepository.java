package com.accesoSeguridad.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesoSeguridad.models.Vehiculo;
import com.accesoSeguridad.models.Visitante;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long>{

	public List<Vehiculo> findByVehiculoPlacaContainingIgnoreCase(String term);
	public Optional<Vehiculo> findByVehiculoCodigo(Long vehiculoCodigo);

}
