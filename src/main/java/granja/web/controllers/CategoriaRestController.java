package granja.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import granja.web.models.Categoria;
import granja.web.services.CategoriaServiceImplement;

@RequestMapping("/api3")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE})
public class CategoriaRestController {

	@Autowired
	private CategoriaServiceImplement categoriaServiceImplement;
	
	@PostMapping
	@RequestMapping(value = "/guardar/categoria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Categoria guardarCategoria(@RequestBody Categoria categoria) {
		return categoriaServiceImplement.guardarCategoria(categoria);
	}
	
	@RequestMapping("/eliminar/categoria") //FUNCIONA
	public String eliminarCategoria(@RequestParam(value = "id", required = true) Long id) {
		return categoriaServiceImplement.eliminarCategoria(id);
	}
	
	@RequestMapping("/actualizar/categoria")
	public String actualizarCategoria(@RequestBody Categoria categoria) {
		if(categoria.getId()!=null) {
			return categoriaServiceImplement.actualizarCategoria(categoria);
		}
		return "No se actualizó la categoria";
	}
	
	@RequestMapping("/obtener/categoria") //FUNCIONA
	public Categoria obtenerCategoria(@RequestParam(value = "id", required = true) Long id) {
		return categoriaServiceImplement.obtenerCategoria(id);
	}
	
	@RequestMapping("/listar/categorias") //FUNCIONA
	public List<Categoria> listaCategoria(){
		return categoriaServiceImplement.listaCategoria();
	}
}


