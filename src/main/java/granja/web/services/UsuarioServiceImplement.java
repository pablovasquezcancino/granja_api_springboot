package granja.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granja.web.models.Usuario;
import granja.web.repositories.UsuarioRepository;


@Service
public class UsuarioServiceImplement implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
// Aquí realizamos toda la lógica de negocio del sistema Web, (Existe correo?, existe web?)
	
	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	

	@Override
	public String eliminarUsuario(Long id) {
		Boolean existe = usuarioRepository.existsById(id);
		
		if(existe) {
			//elimino el usuario pasando el id (pk)
			usuarioRepository.deleteById(id);
		}else {
			return "Usuario no existe en la tabla";
		}
		
		existe = usuarioRepository.existsById(id);
		
		//si es distinto de nulo, no fue eliminado
		if(existe) {
			return "Usuario no eliminado";
		}
		
		return "El usuario fue eliminado";
	}
	
	/*@Override
	public String actualizarUsuario(Usuario usuario) {
		
		Boolean existe = usuarioRepository.existsById(usuario.getId());
		if (existe) {
			usuarioRepository.save(usuario);
			return "Usuario actualizado";
		}
		return "Usuario Creado";
	}*/
	
	
	@Override
	public Usuario obtenerUsuario(Long id) {
		//Optional<Usuario> user = usuarioRepository.findById(id);  este era el método de brisa
		Boolean existe = usuarioRepository.existsById(id);
		
		if(existe) {
		Usuario user= usuarioRepository.findById(id).get();
			return user;
		}
		return null;
	}
	
	@Override
	public List<Usuario> obtenerListaUsuarios() {
		//obtener todos los usuarios
		return usuarioRepository.findAll();
	}


	@Override
	public String actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}
}
