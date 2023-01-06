package granja.web.services;

import java.util.List;

import granja.web.models.Usuario;



public interface UsuarioService {
	
	// Aquí definimos métodos
	
	public Usuario guardarUsuario(Usuario usuario);
	public String eliminarUsuario(Long id);
	public String actualizarUsuario(Usuario usuario);
	public Usuario obtenerUsuario(Long id);	
	public List<Usuario> obtenerListaUsuarios();

}
