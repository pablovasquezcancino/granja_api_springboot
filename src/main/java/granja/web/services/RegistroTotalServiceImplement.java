package granja.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import granja.web.models.RegistroTotal;
import granja.web.repositories.RegistroTotalRepository;

@Service
public class RegistroTotalServiceImplement implements RegistroTotalService{

	@Autowired // permite facilitar la inyeccion en este caso en usRepository
	private RegistroTotalRepository registroRepository;
	
	@Override
	public RegistroTotal guardarRegistro(RegistroTotal registro) {
		//inserta nuevo registro cuando no existe y actualiza cuandoes un mismo id
		registroRepository.save(registro); //Ocupamos el metodo guardar 
		return registroRepository.save(registro);
	}

	@Override
	public String eliminarRegistro(Long id) {
		Boolean existe = registroRepository.existsById(id);
		if(existe) {
			//elimino el usuario pasando el id (pk)
			registroRepository.deleteById(id);
		}else {
			return"Usuario no existe en la tabla";
		}
		//reseteo de valor
		existe= registroRepository.existsById(id);
		
		//validacion de si fue eliminado o no el registro
		//Optional<Usuario> usuario = usRepository.findById(id);
		//si es distinto a null
		if(existe) {
			return "Usuario no eliminado";
		}
		
		return "El usuario fue eliminado";
	}

	/*@Override
	public String actualizarRegistro(RegistroTotal registro) {
		Boolean existe = registroRepository.existsById(registro.getId());
		if(existe) {
			registroRepository.save(registro);
			return "Usuario actualizado";
		}
		return "Usuario no actualizado";
	}*/

	@Override
	public RegistroTotal obtenerRegistro(Long id) {
		Boolean existe = registroRepository.existsById(id);
		
		if(existe) {
		RegistroTotal user= registroRepository.findById(id).get();
			return user;
		}
		return null;
	}

	@Override
	public List<RegistroTotal> ListarRegistros() {
		return registroRepository.findAll();
	}

	@Override
	public String actualizarRegistro(RegistroTotal registro) {
		// TODO Auto-generated method stub
		return null;
	}

}
