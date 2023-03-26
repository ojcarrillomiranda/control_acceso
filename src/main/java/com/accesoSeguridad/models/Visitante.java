package com.accesoSeguridad.models;

import java.sql.Date;
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
@Table(name = "tb_visitantes")
public class Visitante {

    @Id
    @Column(name = "visitante_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitanteCodigo;

    @Column(name = "visitante_identificacion", nullable = false, columnDefinition = "text",unique=true )
    private String visitanteIdentificacion;

    @Column(name = "visitante_apellidos", nullable = false, columnDefinition = "text")
    private String visitanteApellidos;

    @Column(name = "visitante_nombres", nullable = false, columnDefinition = "text")
    private String visitanteNombres;

    @Column(name = "visitante_telefono", columnDefinition = "text")
    private String visitanteTelefono;

    @Column(name = "visitante_arl_ruta", columnDefinition = "text")
    private String visitanteArlRuta;

    @Column(name = "visitante_arl_archivo", columnDefinition = "text")
    private String visitanteArlArchivo;
    
  
    @Column(name = "visitante_arl_fecha_vencimiento", nullable = false, updatable = false)
    private Date visitanteArlFechaVencimiento ;

    @Column(name = "visitante_fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime visitanteFechaCreacion = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "usuario_codigo", foreignKey = @ForeignKey(name = "visitante_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuarios on update restrict on delete restrict"),
    		 columnDefinition="integer default 1")
    Usuario usuario;

}
