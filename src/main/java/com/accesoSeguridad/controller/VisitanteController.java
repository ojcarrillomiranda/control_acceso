package com.accesoSeguridad.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.accesoSeguridad.models.Visitante;
import com.accesoSeguridad.service.VehiculoService;
import com.accesoSeguridad.service.VisitanteService;

@Controller
@RequestMapping
public class VisitanteController {
	
	@Autowired
	private VisitanteService service;

	@Autowired
	private VehiculoService vehiculo;

	@GetMapping("/")
	public String index(Model model, String term) {
		long totalVisitantes = service.contador();
		long totalVehivulos = vehiculo.contador();
		model.addAttribute("totalVisitantes", totalVisitantes);
		model.addAttribute("totalVehiculos", totalVehivulos);
		return "adminlte_templates/home";
	}


	@GetMapping("visitantes/buscar")
	public String listar(Model model, String term) {
		List<Visitante>visitantes=service.listar(term);
		model.addAttribute("visitantes",visitantes);
		return "visitantes/index";
	}

	@GetMapping(value = "/visitantes/ajax/{term}", produces = "application/json")
	public @ResponseBody List<Visitante> visitantes(@PathVariable String term){

		return service.listar(term);
	}

	@GetMapping("visitantes/crear")
	public String agregar(Model model) throws IOException {
		model.addAttribute("visitante",new Visitante());
		return "visitantes/create";
	}

	@PostMapping("visitantes/savefoto")
	public String savefoto(@RequestParam("foto") String foto, @RequestParam("visitanteIdentificacion") String visitanteIdentificacion) {
		System.out.println("********************SAVEFOTO****************");
		Path directorioImagenesFoto = Paths.get("src//main//resources/tmp");
		String rutaAbsolutaFoto = directorioImagenesFoto.toFile().getAbsolutePath();
		System.out.println("RUTA ABSOLUTA EN LA FUNCION savefoto :"+rutaAbsolutaFoto);

		byte[] imageBytes = Base64.getDecoder().decode(foto.split(",")[1]);
		try {
			FileOutputStream fos = new FileOutputStream(rutaAbsolutaFoto+"/foto_" + visitanteIdentificacion +".jpeg");
			System.out.println("fos::::::::::::::::"+ fos);
			fos.write(imageBytes);
			fos.close();


		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/visitantes/buscar";

	}
	//aqui debe llegar la foto en base64
	@PostMapping("visitantes/save")

	public String save(@Valid Visitante visitante, Model model,@RequestParam("arlArchivoImagen")  MultipartFile imagenArl, RedirectAttributes mensaje,String term) {

		if(!imagenArl.isEmpty()) {
			Path directorioImagenesArl = Paths.get("src//main//resources//static/arl");
			String rutaAbsolutaArl = directorioImagenesArl.toFile().getAbsolutePath();
			try {
				byte[] byteImgArl = imagenArl.getBytes();
				Path rutaCompleta = Paths.get(directorioImagenesArl + "//" + imagenArl.getOriginalFilename());
				Files.write(rutaCompleta,byteImgArl);

				visitante.setVisitanteArlArchivo(imagenArl.getOriginalFilename());
				visitante.setVisitanteArlRuta("/arl");
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		//si viene vacio...
		else {
			//si esta editando.
			if (visitante.getVisitanteCodigo()!= null) {
				Optional<Visitante> consulta = service.listarId(visitante.getVisitanteCodigo());
				String archivo = consulta.get().getVisitanteArlArchivo();
				String ruta    = consulta.get().getVisitanteArlRuta();

				if (archivo != null &&  ruta != null){
					visitante.setVisitanteArlArchivo(archivo);
					visitante.setVisitanteArlRuta(ruta);
				}
			} //fin si esta editando...
		}//fin si viene vacio

		service.save(visitante);
		mensaje.addFlashAttribute("guardar","guardar");
		return "redirect:/visitantes/buscar";
	}


	@GetMapping("visitantes/editar/{visitanteCodigo}")
	public String editar(@PathVariable Long visitanteCodigo ,Model model) {
		java.util.Optional<Visitante>visitante=service.listarId(visitanteCodigo);
		model.addAttribute("visitante",visitante);
		return "visitantes/create";
	}


	@GetMapping("visitantes/eliminar/{visitanteCodigo}")
	public String delete(Model model,@PathVariable Long visitanteCodigo) {
		service.delete(visitanteCodigo);
		return "redirect:visitantes/buscar";
	}

	@GetMapping("visitantes/imagen/{visitanteCodigo}")
	public String imagen(@PathVariable Long visitanteCodigo ,Model model) {
		java.util.Optional<Visitante>visitante=service.listarId(visitanteCodigo);
		model.addAttribute("visitante",visitante);
		return "imagen";
	}

	@GetMapping("visitantes/guardar-foto")
	@ResponseBody
	public String guardarFoto(){
		System.out.println("llego ala funcion de  la foto");
		return "OK";
	}


}
