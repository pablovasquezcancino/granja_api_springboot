package granja.web.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table (name="categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nombreCategoria;
	
	private Long valorCaja;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date fecha;
	
	
	
	public Categoria() {
		super();
	}

	
	public Categoria(Long id, @NotNull String nombreCategoria, @NotNull Long valorCaja, Hilera hilera) {
		super();
		this.id = id;
		this.nombreCategoria = nombreCategoria;
		this.valorCaja = valorCaja;
		this.hilera = hilera;
		this.fecha = fecha;
	}

	



	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreCategoria() {
		return nombreCategoria;
	}


	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}


	public Long getValorCaja() {
		return valorCaja;
	}


	public void setValorCaja(Long valorCaja) {
		this.valorCaja = valorCaja;
	}


	public Hilera getHilera() {
		return hilera;
	}


	public void setHilera(Hilera hilera) {
		this.hilera = hilera;
	}





		//ManyToOne de Categoria proveniente de Hileras
		@JsonIgnore
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="hilera_id")
		private Hilera hilera;



}
