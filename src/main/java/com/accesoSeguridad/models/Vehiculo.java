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
@Table(name = "tb_vehiculos")
public class Vehiculo {

    @Id
    @Column(name = "vehiculo_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehiculoCodigo;

    @Column(name = "vehiculo_placa", length = 10, columnDefinition = "text")
    private String vehiculoPlaca;

    @Column(name = "vehiculo_trailer",length = 30, columnDefinition = "text")
    private String vehiculoTrailer;

    @Column(name = "vehiculo_color", length = 30,nullable = false, columnDefinition = "text")
    private String vehiculoColor;

    @Column(name = "vehiculo_modelo", columnDefinition = "text")
    private String vehiculoModelo;

    @Column(name = "vehiculo_fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime vehiculoFechaCreacion = LocalDateTime.now();

    @Column(name = "vehiculo_activo", nullable = false, columnDefinition="boolean default true")
   	private boolean vehiculoActivo = true;

    @ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "vehiculo_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuarios on update restrict on delete restrict"))
	Usuario usuario ;

    @Column(name = "vehiculo_clase", nullable = false, columnDefinition = "text")
    private String vehiculoClase;

}
