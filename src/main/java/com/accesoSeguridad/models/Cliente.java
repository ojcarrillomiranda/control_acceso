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
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @Column(name = "cliente_codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteCodigo;
    
    @Column(name = "cliente_nombre", nullable = false,length = 40, columnDefinition = "text")
    private String clienteNombre;

    @Column(name = "cliente_activo", nullable = false, columnDefinition="boolean default true")
  	private boolean clienteActivo = true;

    @ManyToOne
	@JoinColumn(name = "usuario_codigo",foreignKey=@ForeignKey(name = "cliente_fk_usuario_codigo", foreignKeyDefinition = "foreign key (usuario_codigo) references tb_usuarios on update restrict on delete restrict"))
	Usuario usuario;



}
