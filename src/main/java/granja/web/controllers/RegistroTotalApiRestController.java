 package granja.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import granja.web.models.RegistroTotal;
import granja.web.services.RegistroTotalServiceImplement;



@RestController
public class RegistroTotalApiRestController {
	@Autowired // inyectar informacion del implement en este caso
	private RegistroTotalServiceImplement registroImplement;
	//localhost:9080/guardar/usuario
	@RequestMapping("/guardar/registro")
	//inyectando dependencias para hacer uso de metodos
	public RegistroTotal guardarRegistro(RegistroTotal registro) { //captura el cuerpo del mensaje del postman
		registroImplement.guardarRegistro(registro);
		return registroImplement.guardarRegistro(registro);
	}
	
	@RequestMapping("/eliminar/registro")
	//localhost:9080/eliminar/usuario
	public String eliminarUsuario(@RequestParam(value="id",required = false) Long id) {
		return registroImplement.eliminarRegistro(id);
	}
	
	public String actualizarUsuario(@RequestBody RegistroTotal registro) {
		if(registro.getId()!=null) {
			String mensaje=registroImplement.actualizarRegistro(registro);
			return mensaje;
		}
		return "No se actualiza ningun usuario";
	}
	
	@RequestMapping("/obtener/registro")
	public RegistroTotal obtenerRegistro(@RequestParam(value="id",required = false) Long id){
			return registroImplement.obtenerRegistro(id);		
	}
	
	@GetMapping("/listar/registros")
	public List<RegistroTotal> ListarRegistros(){
			return registroImplement.ListarRegistros();		
	}
}
