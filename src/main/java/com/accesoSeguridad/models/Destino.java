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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="tb_destinos")
public class Destino {
	@Id
	@Column(name = "destino_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long destinoCodigo;

	@Column(name = "destino_nombre", nullable = false, columnDefinition = "text")
	private String destinoNombre;

	@Column(name = "destino_fecha_creacion", nullable = false, updatable = false)
	private LocalDateTime destinoFechaCreacion = LocalDateTime.now();
	
    @Column(name = "destino_activo", nullable = false, columnDefinition="boolean ")
	private boolean destinoActivo = true;
    
    @ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "destino_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuarios on update restrict on delete restrict"))
	Usuario usuario;

    
    @ManyToOne
	@JoinColumn(name = "color_codigo",nullable = false,foreignKey=@ForeignKey(name = "destino_fk_color_codigo", foreignKeyDefinition = "foreign key (color_codigo) references tb_colores on update restrict on delete restrict"))
	private Color color;

    

}
