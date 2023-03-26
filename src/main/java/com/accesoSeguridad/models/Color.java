package com.accesoSeguridad.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="tb_colores")
public class Color {
	@Id
	@Column(name = "color_codigo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long colorCodigo;

	@Column(name = "color_nombre", nullable = false, columnDefinition = "text")
	private String colorNombre;

	
	
    @Column(name = "color_hexadecimal", nullable = false, columnDefinition="text ")
	private String colorHexadecimal;

  

}
