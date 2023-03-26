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

import com.accesoSeguridad.models.Destino;
import com.accesoSeguridad.models.SubDestino;
import com.accesoSeguridad.service.DestinoService;
import com.accesoSeguridad.service.SubdestinoService;

@Controller
@RequestMapping("subdestinos/")
public class SubdestinoController {
	
	@Autowired
	private SubdestinoService service;
	
	@Autowired
	private DestinoService destinoService;
	

	@GetMapping("buscar")
	public String listarSubdestinos(Model model) {
		List<SubDestino>subdestinos = service.listarSubDestino();
		model.addAttribute("subdestinos",subdestinos);
		return "subdestinos/index";
	}


	@GetMapping("editar/{subdestinoCodigo}")
	public String editarSubdestino(@PathVariable("subdestinoCodigo") Long subdestinoCodigo ,Model model) {
		List<Destino>destinos = destinoService.listarDestino();
		model.addAttribute("destinos",destinos);
		java.util.Optional<SubDestino> subdestino = service.listarSubDestinoId(subdestinoCodigo);
		model.addAttribute("subdestino",subdestino);
		model.addAttribute("editar","1");
		
		return "subdestinos/create";
	}

	
	@GetMapping("crear")
	public String agregar(Model model, SubDestino subdestino) {
		List<Destino>destinos = destinoService.listarDestino();
		model.addAttribute("subdestino",new SubDestino());
		model.addAttribute("destinos",destinos);
		
		return "subdestinos/create";
	}

	@PostMapping("save")
	public String saveSubdestino(@Valid @ModelAttribute SubDestino subdestino, Model model,RedirectAttributes mensaje) {
		
		service.guardarSubdestino(subdestino);
		mensaje.addFlashAttribute("guardar","guardar");
		return "redirect:/subdestinos/buscar";
	}
	
	

}
