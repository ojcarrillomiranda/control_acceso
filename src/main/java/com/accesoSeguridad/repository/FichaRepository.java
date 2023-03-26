package com.accesoSeguridad.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accesoSeguridad.models.Ficha;

@Repository
public interface FichaRepository extends JpaRepository<Ficha, Long> {

	public Optional<Ficha> findById(Long fichaCodigo);
	
//	@Query(value="\n"
//			+ "select *\n"
//			+ "from\n"
//			+ "	tb_fichas f\n"
//			+ "left join tb_destinos d on\n"
//			+ "	(f.destino_codigo = d.destino_codigo)\n"
//			+ "left join tb_colores col on\n"
//			+ "	(d.color_codigo = col.color_codigo)\n"
//			+ "where\n"
//			+ "	f.ficha_activo and f.destino_codigo =?1  ",nativeQuery = true)
//	List<Ficha> findByDestinoCodigoActivas(int color);

	
	
}
