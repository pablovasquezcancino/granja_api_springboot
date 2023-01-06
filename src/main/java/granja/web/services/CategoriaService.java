package granja.web.services;

import java.util.List;

import granja.web.models.Categoria;





public interface CategoriaService {

	public Categoria guardarCategoria(Categoria categoria);
	public String eliminarCategoria(Long id);
	public String actualizarCategoria(Categoria categoria);
	public Categoria obtenerCategoria(Long id);
	public List<Categoria> listaCategoria();
}
