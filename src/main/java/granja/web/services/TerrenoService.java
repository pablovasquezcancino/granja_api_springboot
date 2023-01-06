package granja.web.services;

import java.util.List;

import granja.web.models.Terreno;






public interface TerrenoService {
	
	public Terreno guardarTerreno(Terreno terreno);
	public String eliminarTerreno(Long id);
	public Terreno obtenerTerreno(Long id);	
	public String actualizarTerreno(Terreno terreno);
	public List<Terreno> obtenerListaTerrenos();

}

