package com.accesoSeguridad.interfaces;

import java.util.List;
import java.util.Optional;

import com.accesoSeguridad.models.Cliente;

public interface ICliente {
	List<Cliente>listarClientes();
    Optional<Cliente>listarClienteId(Long clienteCodigo);
	int guardarCliente(Cliente cliente);
	Long contador();

}
