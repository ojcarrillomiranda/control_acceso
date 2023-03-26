package com.accesoSeguridad.models;

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
@Table(name = "tb_acciones")
public class Accion {

    @Id
    @Column(name = "accion_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accionCodigo;

    @Column(name = "accion_nombre", length = 40, columnDefinition = "text")
    private String accionNombre;

    @Column(name = "accion_activo", nullable = false, columnDefinition="boolean default true")
   	private boolean accionActivo;


    @ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "accion_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuarios on update restrict on delete restrict"))
	Usuario usuario;

    @ManyToOne
	@JoinColumn(name = "subdestino_codigo",nullable = false,foreignKey=@ForeignKey(name = "accion_fk_subdestino_codigo", foreignKeyDefinition = "foreign key (subdestino_codigo) references tb_subdestinos on update restrict on delete restrict"))
    SubDestino subDestino;
    

}
