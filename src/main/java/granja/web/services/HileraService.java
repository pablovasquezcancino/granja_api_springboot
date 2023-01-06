package granja.web.services;

import java.util.List;

import granja.web.models.Hilera;





public interface HileraService {

	public Hilera guardarHilera(Hilera hilera);
	public String eliminarHilera(Long id);
	public String actualizarHilera(Hilera hilera);
	public Hilera obtenerHilera(Long id);
	public List<Hilera> listaHilera();
}
