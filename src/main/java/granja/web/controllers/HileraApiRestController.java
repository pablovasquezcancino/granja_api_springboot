package granja.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import granja.web.models.Hilera;
import granja.web.services.HileraServiceImplement;



@RestController
public class HileraApiRestController {
	
	@Autowired
	private HileraServiceImplement hileraServiceImplement;
	
	@RequestMapping("/guardar/hilera")//FUNCIONA
	public Hilera guardarHilera(@RequestBody Hilera hilera) {
		return hileraServiceImplement.guardarHilera(hilera);
	}
	
	@RequestMapping("/eliminar/hilera") //FUNCIONA
	public String eliminarHilera(@RequestParam(value = "id", required = true) Long id) {
		return hileraServiceImplement.eliminarHilera(id);
	}
	
	@RequestMapping("/actualizar/hilera")
	public String actualizarHilera(@RequestBody Hilera hilera) {
		if(hilera.getId()!=null) {
			return hileraServiceImplement.actualizarHilera(hilera);
		}
		return "No se actualizó la hilera";
	}
	
	@RequestMapping("/obtener/hilera")//FUNCIONA
	public Hilera obtenerHilera(@RequestParam(value = "id", required = true) Long id) {
		return hileraServiceImplement.obtenerHilera(id);
	}
	
	@RequestMapping("/listar/hileras") //FUNCIONA
	public List<Hilera> listaCategoria(){
		return hileraServiceImplement.listaHilera();
	}
	
}
