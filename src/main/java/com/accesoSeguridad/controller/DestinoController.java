package com.accesoSeguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.accesoSeguridad.models.Color;
import com.accesoSeguridad.models.Destino;
import com.accesoSeguridad.service.DestinoService;

@Controller
@RequestMapping("destinos/")
public class DestinoController {
	
	@Autowired
	private DestinoService service;
	
	
	
	@GetMapping("crear")
	public String agregar(Model model) {
		List<Color>colores   = service.listarColores();
		model.addAttribute("destino",new Destino());
		model.addAttribute("colores",colores);
		
		
		return "destinos/create";
	}


	@GetMapping("buscar")
	public String listar(Model model) {
		List<Destino>destinos = service.listarDestino();
		model.addAttribute("destinos",destinos);
		return "destinos/index";
	}



	@GetMapping("editar/{destinoCodigo}")
	public String editar(@PathVariable("destinoCodigo") Long destinoCodigo ,Model model) {
		java.util.Optional<Destino> destino = service.listarDestinoId(destinoCodigo);
		List<Color>colores   = service.listarColores();
		model.addAttribute("destino",destino);
		model.addAttribute("colores",colores);
		model.addAttribute("editar","1");
		return "destinos/create";
	}


	@PostMapping("save")
	public String save(@Valid @ModelAttribute Destino destino, Model model,RedirectAttributes mensaje) {
		
		service.save(destino);
		mensaje.addFlashAttribute("guardar","guardar");
		return "redirect:buscar";
	}
	
	
	

}
