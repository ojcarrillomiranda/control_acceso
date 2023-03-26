package com.accesoSeguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesoSeguridad.interfaces.ICliente;
import com.accesoSeguridad.models.Cliente;
import com.accesoSeguridad.repository.ClienteRepository;


@Service
public class ClienteService implements ICliente {
	
	@Autowired
	ClienteRepository data;
		 

	@Override
	public Long contador() {
		return data.count();
	}

	@Override
	public List<Cliente> listarClientes() {
		return data.findAll();
	}

	@Override
	public Optional<Cliente> listarClienteId(Long clienteCodigo) {
		return data.findById(clienteCodigo);
	}

	@Override
	public int guardarCliente(Cliente cliente) {
		int res = 0;
		Cliente c = data.save(cliente);
		if (!c.equals(null)) {
			res = 1;
		}
		return res;
	}

}
