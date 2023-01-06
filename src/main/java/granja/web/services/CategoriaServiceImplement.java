package granja.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import granja.web.models.Categoria;
import granja.web.repositories.CategoriaRepository;


@Service
public class CategoriaServiceImplement implements CategoriaService{
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria guardarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public String eliminarCategoria(Long id) {
		Boolean existe = categoriaRepository.existsById(id);
		if(existe) {
		categoriaRepository.deleteById(id);
		}else {
			return "La categoria no existe";
		}
			
		return "Categoria eliminada";
	}

	/*@Override
	public String actualizarCategoria(Categoria categoria) {
		Boolean existe = categoriaRepository.existsById(categoria.getId());
		if (existe) {
			categoriaRepository.save(categoria);
			return "Categoria actualizada";
		}
		return "Categoria no actualizada";
	}*/

	@Override
	public Categoria obtenerCategoria(Long id) {
		return categoriaRepository.findById(id).get();
	}

	@Override
	public List<Categoria> listaCategoria() {
		return categoriaRepository.findAll();
	}

	@Override
	public String actualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}
}
