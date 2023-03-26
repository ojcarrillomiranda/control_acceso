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
@Table(name = "tb_fichas")
public class Ficha {

    @Id
    @Column(name = "ficha_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fichaCodigo;

    @Column(name = "ficha_numero", length = 10, columnDefinition = "text")
    private String fichaNumero;

    @Column(name = "ficha_fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fichaFechaCreacion = LocalDateTime.now();

  
    @Column(name = "ficha_activo", nullable = false, columnDefinition="boolean default true")
	private boolean fichaActivo = true;


    @ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "ficha_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuarios on update restrict on delete restrict"))
	Usuario usuario;

    
    @ManyToOne
	@JoinColumn(name = "destino_codigo",foreignKey=@ForeignKey(name = "ficha_fk_destino_codigo", foreignKeyDefinition = "foreign key (destino_codigo) references tb_destinos on update restrict on delete restrict"))
	private Destino destino;


    

    

}
