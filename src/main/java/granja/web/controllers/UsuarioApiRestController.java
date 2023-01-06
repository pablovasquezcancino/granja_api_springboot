package granja.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import granja.web.models.Usuario;
import granja.web.services.UsuarioServiceImplement;



@RestController
public class UsuarioApiRestController {
	
	@Autowired
	private UsuarioServiceImplement usuarioServiceImplement;
	
	@RequestMapping("/guardar/usuario") //FUNCIONA
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return usuarioServiceImplement.guardarUsuario(usuario);
	}
	
	@RequestMapping("/eliminar/usuario") // FUNCIONA
	public String eliminarUsuario(@RequestParam(value = "id", required = false) Long id){
		// Aqui llamamos al metodo eliminar en el servicio
		return usuarioServiceImplement.eliminarUsuario(id);
	}
	
	@RequestMapping("/actualizar/usuario")
	public String actualizarUsuario(@RequestBody Usuario usuario) {
		if (usuario.getId()!=null) {
			String mensaje = usuarioServiceImplement.actualizarUsuario(usuario);
			return mensaje;
		}
		return "No se actualizará ningun usuario";
	}
	
	@RequestMapping("/obtener/usuario") // FUNCIONA
	public Usuario obtenerUsuario(@RequestParam(value="id",required = true) Long id){
		
		return usuarioServiceImplement.obtenerUsuario(id);
				
	}
	
	// AHora vamos a listar a todos los usuarios
	@GetMapping("listar/usuarios") // FUNCIONA
	public List<Usuario> obtenerListaUsuarios(){
		return usuarioServiceImplement.obtenerListaUsuarios();
	}
}
