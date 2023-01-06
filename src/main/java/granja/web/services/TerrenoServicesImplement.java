package granja.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granja.web.models.Terreno;
import granja.web.repositories.TerrenoRepository;



@Service
public class TerrenoServicesImplement implements TerrenoService{
	
	@Autowired
	private TerrenoRepository terrenoRepository;

	// Guardar Terreno
	@Override
	public Terreno guardarTerreno(Terreno terreno) {
		return terrenoRepository.save(terreno);
	}

	// Eliminar Terreno
	@Override
	public String eliminarTerreno(Long id) {
		Boolean existe = terrenoRepository.existsById(id);
		if (existe) {
			terrenoRepository.deleteById(id);
		} else {
			return "Terreno no existe en la tabla";
		}
		existe = terrenoRepository.existsById(id);
		// Si es distinto de nulo mostrará: No fue eliminado
		if (existe) {
			return "Terreno no eliminado";
		}
		return "El terreno fue eliminado";
	}

	// Actualizar Terreno
	/*@Override
	public String actualizarTerreno(Terreno terreno) {

		Boolean existe = terrenoRepository.existsById(terreno.getId());
		if (existe) {
			terrenoRepository.save(terreno);
			return "Terreno Actualizado";
		}
		return "Terreno Creado";
	}*/

	// Obtener Terreno
	@Override
	public Terreno obtenerTerreno(Long id) {
		Boolean existe = terrenoRepository.existsById(id);

		if (existe) {
			Terreno user = terrenoRepository.findById(id).get();
			return user;
		}
		return null;
	}

	@Override
	public List<Terreno> obtenerListaTerrenos() {
		// obtener todos los Terrenos
		return terrenoRepository.findAll();
	}

	@Override
	public String actualizarTerreno(Terreno terreno) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
