package granja.web.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name="hileras")
public class Hilera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nombreHilera;
	@NotNull
	private String descripcionHilera;
	
	

	
	public Hilera() {
		super();
	}
	
	

	public Hilera(Long id, @NotNull String nombreHilera, @NotNull String descripcionHilera, Terreno terreno,
			List<Categoria> categorias) {
		super();
		this.id = id;
		this.nombreHilera = nombreHilera;
		this.descripcionHilera = descripcionHilera;
		this.terreno = terreno;
		this.categorias = categorias;
	}

	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombreHilera() {
		return nombreHilera;
	}



	public void setNombreHilera(String nombreHilera) {
		this.nombreHilera = nombreHilera;
	}



	public String getDescripcionHilera() {
		return descripcionHilera;
	}



	public void setDescripcionHilera(String descripcionHilera) {
		this.descripcionHilera = descripcionHilera;
	}



	public Terreno getTerreno() {
		return terreno;
	}



	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}



	public List<Categoria> getCategorias() {
		return categorias;
	}



	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}




	//ManyToOne de Hilera proveniente de Terrenos
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="terreno_id")
	private Terreno terreno;
	
	//One to Many para Categorías
	@JsonIgnore
	@OneToMany(mappedBy = "hilera",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Categoria> categorias;




}
