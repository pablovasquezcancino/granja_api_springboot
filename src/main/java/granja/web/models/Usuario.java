package granja.web.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	private int edad;
	@NotNull
	private String genero;
	@NotNull
	private String correo;
	@NotNull
	private String password;
	@Transient
	private String password2;
	@NotNull
	private String descripcion;
	@NotNull
	private int telefono; 
	
	
	
	
	public Usuario() {
		super();
	}
	
	

	public Usuario(Long id, @NotNull String nombre, @NotNull String apellido, @NotNull int edad, @NotNull String genero,
			@NotNull String correo, @NotNull String password, String password2, @NotNull String descripcion,
			@NotNull int telefono, Empresa empresa, List<Rol> roles, List<RegistroTotal> registroTotales) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.correo = correo;
		this.password = password;
		this.password2 = password2;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.empresa = empresa;
		this.roles = roles;
		this.registroTotales = registroTotales;
	}

		

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPassword2() {
		return password2;
	}



	public void setPassword2(String password2) {
		this.password2 = password2;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public Empresa getEmpresa() {
		return empresa;
	}



	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	public List<Rol> getRoles() {
		return roles;
	}



	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}



	public List<RegistroTotal> getRegistroTotales() {
		return registroTotales;
	}



	public void setRegistroTotales(List<RegistroTotal> registroTotales) {
		this.registroTotales = registroTotales;
	}



	//ManyToOne de Empresa
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="empresa_id")
	private Empresa empresa;
	
	// Relacion ManytoMany proveniente de roles

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "roles_usuarios", // nombre de la tabla relacional
			joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private List<Rol> roles;
	
	//One to Many para Registros Totales
	@JsonIgnore
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<RegistroTotal> registroTotales;
	
	
	
}
