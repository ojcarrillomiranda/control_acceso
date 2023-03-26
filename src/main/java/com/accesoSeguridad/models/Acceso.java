package com.accesoSeguridad.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="tb_accesos")
public class Acceso {


	@Id
	@Column(name = "acceso_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accesoCodigo;


	@Column(name = "acceso_fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime accesoFechaCreacion = LocalDateTime.now();

	@Column(name = "acceso_fecha_ingreso",updatable = false)
	private LocalDateTime accesoFechaIngreso = LocalDateTime.now() ;


	@Column(name = "acceso_fecha_salida", updatable = false)
	private LocalDateTime accesoFechaSalida ;

	
	@ManyToOne
	@JoinColumn(name = "visitante_codigo",foreignKey=@ForeignKey(name = "acceso_fk_visitante_codigo", foreignKeyDefinition = "foreign key (visitante_codigo) references tb_visitantes on update restrict on delete restrict"))
	Visitante visitante;

	
	
	
	
	@ManyToOne
	@JoinColumn(name = "ciudad_codigo",foreignKey=@ForeignKey(name = "acceso_fk_ciudad_codigo",  foreignKeyDefinition = "foreign key (ciudad_codigo) references tb_ciudades on update restrict on delete restrict"),
			nullable = false)
	Ciudad ciudad;


	@ManyToOne
	@JoinColumn(name = "vehiculo_codigo",foreignKey=@ForeignKey(name = "acceso_fk_vehiculo_codigo",  foreignKeyDefinition = "foreign key (vehiculo_codigo) references tb_vehiculos on update restrict on delete restrict"))
	Vehiculo vehiculo;


	@ManyToOne
	@JoinColumn(name = "cliente_codigo_entrada",foreignKey=@ForeignKey(name = "acceso_fk_cliente_codigo_entrada", foreignKeyDefinition = "foreign key (cliente_codigo_entrada) references tb_clientes on update restrict on delete restrict"))
	Cliente clienteEntrada;

	@ManyToOne
	@JoinColumn(name = "cliente_codigo_salida",foreignKey=@ForeignKey(name = "acceso_fk_cliente_codigo_salida", foreignKeyDefinition = "foreign key (cliente_codigo_salida) references tb_clientes on update restrict on delete restrict"))
	Cliente clienteSalida;


	@ManyToOne
	@JoinColumn(name = "accion_codigo",foreignKey=@ForeignKey(name = "acceso_fk_accion_codigo", foreignKeyDefinition = "foreign key (accion_codigo) references tb_acciones on update restrict on delete restrict"),
			nullable = false)
	Accion accion;
	
	@ManyToOne
	@JoinColumn(name = "ficha_codigo",foreignKey=@ForeignKey(name = "acceso_fk_ficha_codigo", foreignKeyDefinition = "foreign key (ficha_codigo) references tb_fichas on update restrict on delete restrict"),
			nullable = false)
	Ficha ficha;

	@ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "acceso_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuarios on update restrict on delete restrict"))
	Usuario usuario;



}
