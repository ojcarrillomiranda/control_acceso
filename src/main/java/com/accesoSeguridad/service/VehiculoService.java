package com.accesoSeguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesoSeguridad.interfaces.IVehiculo;
import com.accesoSeguridad.models.Vehiculo;
import com.accesoSeguridad.repository.VehiculoRepository;


@Service
public class VehiculoService implements IVehiculo {

	@Autowired
	private VehiculoRepository data;


	@Override
	public Optional<Vehiculo> listarId(Long vehiculoCodigo) {
		return data.findByVehiculoCodigo(vehiculoCodigo);
	}


	@Override
	public int save(Vehiculo vehiculo) {
		int res=0;
		Vehiculo v=data.save(vehiculo);
		if (!v.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(Long vehiculoCodigo) {
		data.deleteById(vehiculoCodigo);

	}

	@Override
	public Long contador() {
		return data.count();
	}


	@Override
	public List<Vehiculo> listar() {
		return data.findAll();
	}


	@Override
	public List<Vehiculo> listarPlaca(String term) {
		// TODO Auto-generated method stub
		System.out.println("valor de term:");
		System.out.println(term);
		return data.findByVehiculoPlacaContainingIgnoreCase(term);
		
	}

}
