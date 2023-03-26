package com.accesoSeguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.accesoSeguridad.models.Vehiculo;
import com.accesoSeguridad.service.VehiculoService;

@Controller
@RequestMapping("vehiculos/")
public class VehiculoController {
	
	@Autowired
	private VehiculoService service;

	@GetMapping("crear")
	public String agregar(Model model) {
		model.addAttribute("vehiculo",new Vehiculo());
		return "vehiculos/create";
	}


	@GetMapping("buscar")
	public String listar(Model model) {
		List<Vehiculo> vehiculos = service.listar();
		model.addAttribute("vehiculos",vehiculos);
		return "vehiculos/index";
	}

	@GetMapping(value = "/ajax/{term}", produces = "application/json")
	public @ResponseBody List<Vehiculo> vehiculos(@PathVariable String term ){
		return service.listarPlaca(term);
		
	}
	
	 

	
	

	@GetMapping("editar/{vehiculoCodigo}")
	public String editar(@PathVariable Long vehiculoCodigo ,Model model) {
		java.util.Optional<Vehiculo> vehiculo = service.listarId(vehiculoCodigo);
		model.addAttribute("vehiculo",vehiculo);

		return "vehiculos/create";
	}


	@PostMapping("save")
	public String save(@Valid Vehiculo vehiculo, Model model,RedirectAttributes mensaje) {
		System.out.println("vehiculo:->"+ vehiculo);

		service.save(vehiculo);
		//Long vehiculoCodigo = vehiculo.getVehiculoCodigo();
		mensaje.addFlashAttribute("guardar","guardar");
		return "redirect:buscar";
//		return "redirect:vehiculos/editar/"+vehiculoCodigo ;
	}




	@GetMapping("vehiculos/eliminar/{vehiculoCodigo}")
	public String delete(Model model,@PathVariable Long vehiculoCodigo) {
		service.delete(vehiculoCodigo);
		return "redirect:vehiculos/buscar";
	}



}
