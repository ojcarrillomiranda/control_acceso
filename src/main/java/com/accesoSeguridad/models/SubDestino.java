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
@Table(name="tb_subdestinos")
public class SubDestino {
	@Id
	@Column(name = "subdestino_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subDestinoCodigo;

	@Column(name = "subdestino_nombre", nullable = false, columnDefinition = "text")
	private String subDestinoNombre;

	@Column(name = "subdestino_encargado", nullable = false, updatable = false,columnDefinition = "text")
	private String subDestinoEncargado;

	@Column(name = "subdestino_fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime subDestinoFechaCreacion = LocalDateTime.now();

	@Column(name = "subdestino_activo", nullable = false, columnDefinition="boolean default true")
	private boolean subDestinoActivo = true;

	
	@ManyToOne
	@JoinColumn(name = "destino_codigo",nullable = false,foreignKey=@ForeignKey(name = "destino_fk_destino_codigo", foreignKeyDefinition = "foreign key (destino_codigo) references tb_destinos on update restrict on delete restrict"))
	Destino destino;
	

	@ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "subdestino_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuarios on update restrict on delete restrict"))
	Usuario usuario;




}
