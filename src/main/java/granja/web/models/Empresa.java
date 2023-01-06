package granja.web.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="empresas")
public class Empresa{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto incrementable
	
	private Long Id;
	@NotNull
	private String nombreEmpresa;
	@NotNull
	private String rutEmpresa;
	@NotNull
	private String representante;
	@NotNull
	private String rutRepresentante;
	@NotNull
	private int telefonoRepresentante;
	
	//One to Many para Usuarios
	@JsonIgnore
	@OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Usuario> usuarios;



}
