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
@Table(name = "tb_usuarios")

public class Usuario {

	@Id
	@Column(name = "usuario_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuarioCodigo;

	@Column(name = "usuario_login", nullable = false, columnDefinition = "text")
	private String usuarioLogin;

	@Column(name = "usuario_nombre", nullable = false, columnDefinition = "text")
	private String usuarioNombre;

	@Column(name = "usuario_clave", nullable = false, columnDefinition = "text")
	private String usuarioClave;

	@Column(name = "usuario_fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime usuarioFechaCreacion = LocalDateTime.now();

	@Column(name = "usuario_activo", nullable = false, columnDefinition="boolean default true")
	private boolean usuarioActivo;

	@ManyToOne
	@JoinColumn(name = "usuario_codigo_creacion",foreignKey=@ForeignKey(name = "usuario_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuarios on update restrict on delete restrict"),
	nullable=false)
	Usuario usuario;


}
