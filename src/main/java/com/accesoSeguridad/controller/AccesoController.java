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

import com.accesoSeguridad.models.Acceso;
import com.accesoSeguridad.models.Accion;
import com.accesoSeguridad.models.Ciudad;
import com.accesoSeguridad.models.Cliente;
import com.accesoSeguridad.models.Destino;
import com.accesoSeguridad.models.Ficha;
import com.accesoSeguridad.models.SubDestino;
import com.accesoSeguridad.models.Vehiculo;
import com.accesoSeguridad.models.Visitante;
import com.accesoSeguridad.service.AccesoService;
import com.accesoSeguridad.service.ClienteService;
import com.accesoSeguridad.service.DestinoService;
import com.accesoSeguridad.service.FichaService;
import com.accesoSeguridad.service.SubdestinoService;
import com.accesoSeguridad.service.VehiculoService;
import com.accesoSeguridad.service.VisitanteService;

@Controller
@RequestMapping("accesos/")
public class AccesoController {
	@Autowired
	private AccesoService service;
	
	@Autowired
	private FichaService fichaService;
	
	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private SubdestinoService subdestinoService;
	
	@Autowired
	private VisitanteService visitanteService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VehiculoService vehiculoService;
	
	
	
	
	 
	@GetMapping("crear")
	public String agregar(Model model) {
		
		model.addAttribute("acceso",new Acceso());
		
		//el metodo del service esta en la Interfaz
		List<Destino>destinos     = destinoService.listarDestino();
		List<SubDestino>subdestinos = subdestinoService.listarSubDestino();
	
		List<Ciudad>ciudades      = service.listarCiudades(); 
		List<Accion>acciones      = service.listarAcciones();
		List<Visitante>visitantes = visitanteService.listarTodos();
		List<Cliente>clientes     = clienteService.listarClientes();
		List<Vehiculo>vehiculos   = vehiculoService.listar();
		List<Ficha> fichas         = fichaService.listar();
		
		System.out.println("********************************");
		System.out.println(acciones);
		System.out.println("**********************************");
				
		model.addAttribute("destinos",destinos);
		model.addAttribute("subdestinos",subdestinos);
		model.addAttribute("ciudades",ciudades);
		model.addAttribute("acciones",acciones);
		model.addAttribute("visitantes",visitantes);
		model.addAttribute("clientes",clientes);
		model.addAttribute("vehiculos",vehiculos);
		model.addAttribute("fichas",fichas);
		
		model.addAttribute("back", "background:");
		return "accesos/create";
	}


	@GetMapping("buscar")
	public String listar(Model model) {
		List<Acceso> accesos = service.listarAccesos();
		model.addAttribute("accesos",accesos);
		return "accesos/index";
	}



	@GetMapping("editar/{accesoCodigo}")
	public String editar(@PathVariable Long accesoCodigo ,Model model) {
		java.util.Optional<Acceso>acceso = service.listarId(accesoCodigo);
		List<Destino>destinos = destinoService.listarDestino();
		List<SubDestino>subdestinos = subdestinoService.listarSubDestino();
		List<Ciudad>ciudades      = service.listarCiudades(); 
		List<Accion>acciones      = service.listarAcciones();
		List<Visitante>visitantes = visitanteService.listarTodos();
		List<Cliente>clientes     = clienteService.listarClientes();
		List<Vehiculo>vehiculos   = vehiculoService.listar();
		List<Ficha>fichas         = fichaService.listar();
		
		model.addAttribute("acceso",acceso);
		model.addAttribute("destinos",destinos);
		model.addAttribute("subdestinos",subdestinos);
		model.addAttribute("ciudades",ciudades);
		model.addAttribute("acciones",acciones);
		model.addAttribute("visitantes",visitantes);
		model.addAttribute("clientes",clientes);
		model.addAttribute("vehiculos",vehiculos);
		model.addAttribute("fichas",fichas);
		
		
		model.addAttribute("editar", "1");
		return "accesos/create";
	}


	@PostMapping("save")
	public String save(@Valid Acceso acceso, Model model,RedirectAttributes mensaje, Ficha ficha) {
		service.save(acceso);
		ficha.setFichaActivo(false);
		fichaService.save(ficha);
		mensaje.addFlashAttribute("guardar","guardar");
		return "redirect:buscar";
	}
	
}
