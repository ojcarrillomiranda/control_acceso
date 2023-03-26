package com.accesoSeguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.accesoSeguridad.models.Cliente;
import com.accesoSeguridad.service.ClienteService;

@Controller
@RequestMapping("clientes/")
public class ClienteController {
	@Autowired
	private ClienteService service;
	
	@GetMapping("crear")
	public String agregar(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "clientes/create";
	}
	
	@GetMapping("buscar")
	public String listar(Model model) {
		List<Cliente>clientes = service.listarClientes();
		model.addAttribute("clientes",clientes);
		return "clientes/index";
	}
	
	@GetMapping("editar/{clienteCodigo}")
	public String editar(@PathVariable Long clienteCodigo ,Model model) {
		java.util.Optional<Cliente>cliente=service.listarClienteId(clienteCodigo);
		model.addAttribute("cliente",cliente);
		return "clientes/create";
	}
	
	@PostMapping("save")
	public String save(@Valid Cliente cliente, Model model,RedirectAttributes mensaje) {
		service.guardarCliente(cliente);
		mensaje.addFlashAttribute("guardar","guardar");
		return "redirect:buscar";
	}

	
	

}
