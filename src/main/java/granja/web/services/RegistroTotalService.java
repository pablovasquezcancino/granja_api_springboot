package granja.web.services;

import java.util.List;

import granja.web.models.RegistroTotal;





public interface RegistroTotalService {
	
	public RegistroTotal guardarRegistro(RegistroTotal registro);
	public String eliminarRegistro(Long id);
	public String actualizarRegistro(RegistroTotal registro);
	public RegistroTotal obtenerRegistro(Long id);
	public List <RegistroTotal> ListarRegistros();
}
