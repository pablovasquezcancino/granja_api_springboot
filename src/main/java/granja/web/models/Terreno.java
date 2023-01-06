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
@Table(name="terrenos")
public class Terreno {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String nombreTerreno;
		@NotNull
		private String descripcionTerreno;
		
		
		
		public Terreno() {
			super();
		}

		
		
		
		public Terreno(Long id, @NotNull String nombreTerreno, @NotNull String descripcionTerreno,
				RegistroTotal registroTotal, List<Hilera> hileras) {
			super();
			this.id = id;
			this.nombreTerreno = nombreTerreno;
			this.descripcionTerreno = descripcionTerreno;
			this.registroTotal = registroTotal;
			this.hileras = hileras;
		}

		


		public Long getId() {
			return id;
		}




		public void setId(Long id) {
			this.id = id;
		}




		public String getNombreTerreno() {
			return nombreTerreno;
		}




		public void setNombreTerreno(String nombreTerreno) {
			this.nombreTerreno = nombreTerreno;
		}




		public String getDescripcionTerreno() {
			return descripcionTerreno;
		}




		public void setDescripcionTerreno(String descripcionTerreno) {
			this.descripcionTerreno = descripcionTerreno;
		}




		public RegistroTotal getRegistroTotal() {
			return registroTotal;
		}




		public void setRegistroTotal(RegistroTotal registroTotal) {
			this.registroTotal = registroTotal;
		}




		public List<Hilera> getHileras() {
			return hileras;
		}




		public void setHileras(List<Hilera> hileras) {
			this.hileras = hileras;
		}




		//ManyToOne de Registrototal proveniente de Registros Totales
		@JsonIgnore
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="registro_id")
		private RegistroTotal registroTotal;
		
		//One to Many para Hilera
		@JsonIgnore
		@OneToMany(mappedBy = "terreno",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private List<Hilera> hileras;

	
	
}
