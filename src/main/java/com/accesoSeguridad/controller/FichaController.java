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
import com.accesoSeguridad.models.Ficha;
import com.accesoSeguridad.service.FichaService;

@Controller
@RequestMapping("fichas/")
public class FichaController {

	@Autowired
	private FichaService service;

	@GetMapping("crear")
	public String agregar(Model model) {
		List<Destino> destinos = service.listarDestino();
		
		model.addAttribute("ficha",new Ficha());
		model.addAttribute("destinos",destinos);
		model.addAttribute("back", "background:");
		return "fichas/create";
	}

	@GetMapping("buscar")
	public String listar(Model model) {
		List<Ficha>fichas = service.listar();
		model.addAttribute("fichas",fichas);
		return "fichas/index";
	}

	@GetMapping("editar/{destinoCodigo}")
	public String editar(@PathVariable("destinoCodigo") Long destinoCodigo ,Model model, Destino destino) {
		java.util.Optional<Ficha> ficha = service.listarId(destinoCodigo);

		
		List<Destino> destinos = service.listarDestino();
		model.addAttribute("destinos",destinos);
		model.addAttribute("ficha",ficha);
		model.addAttribute("editar","1");
		
		return "fichas/create";
	}


	@PostMapping("save")
	public String save(@Valid @ModelAttribute Ficha ficha, Model model,RedirectAttributes mensaje) {
		service.save(ficha);
	    mensaje.addFlashAttribute("guardar","guardar");
		return "redirect:buscar";
	}
	


}
