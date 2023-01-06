package granja.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import granja.web.models.Terreno;
import granja.web.services.TerrenoServicesImplement;



@RestController
public class TerrenoApiRestController {
	@Autowired
	private TerrenoServicesImplement terrenoServiceImplement;
	
	// Guardar Terreno
	@RequestMapping("/guardar/terreno") //FUNCIONA
	public Terreno guardarTerreno(@RequestBody Terreno terreno) {
		
		return terrenoServiceImplement.guardarTerreno(terreno);
	}
	// Eliminar Terreno
	@RequestMapping("/eliminar/terreno") // FUNCIONA
	public String eliminarTerreno(@RequestParam(value = "id", required = false) Long id){
		// Aqui llamamos al metodo eliminar en el servicio
		return terrenoServiceImplement.eliminarTerreno(id);
	}
	// Actualizar Terrenos
	@RequestMapping("/actualizar/terreno")
	public String actualizarTerreno(@RequestBody Terreno terreno) {
		if (terreno.getId()!=null) {
			String mensaje = terrenoServiceImplement.actualizarTerreno(terreno);
			return mensaje;
		}
		return "No se encontró el terreno";
	}
	// Obtener Terreno
	@RequestMapping("/obtener/terreno") //FUNCIONA
	public Terreno obtenerTerreno(@RequestParam(value="id",required = true) Long id){
		
		return terrenoServiceImplement.obtenerTerreno(id);			
	}
	
	// Listar todos los terrenos.

	@GetMapping("listar/terrenos") // FUNCIONA
	public List<Terreno> obtenerListaTerrenos(){
		return terrenoServiceImplement.obtenerListaTerrenos();
	}
	
}
