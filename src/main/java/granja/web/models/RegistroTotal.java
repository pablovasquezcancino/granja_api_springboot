package granja.web.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table (name="registrosTotales")
public class RegistroTotal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;// bigint
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;


	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	
	
	public RegistroTotal() {
		super();
	}

	
	
	public RegistroTotal(Long id, Date fecha, Date createdAt, Date updatedAt, Usuario usuario, List<Terreno> terrenos) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.usuario = usuario;
		this.terrenos = terrenos;
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public List<Terreno> getTerrenos() {
		return terrenos;
	}



	public void setTerrenos(List<Terreno> terrenos) {
		this.terrenos = terrenos;
	}



	//ManyToOne de Registrototal proveniente de Usuario
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	//One to Many para Terreno
	@JsonIgnore
	@OneToMany(mappedBy = "registroTotal",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Terreno> terrenos;


	
}
	
