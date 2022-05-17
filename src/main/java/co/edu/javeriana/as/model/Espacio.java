package co.edu.javeriana.as.model;


import javax.persistence.*;

@Entity	
@Table (name="espacios")
public class Espacio {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_espacio;
	private String sala;
	private int aforo;
	@OneToOne
	@JoinColumn(name="id_edificio")
	private Edificio edificio;

	public Espacio( String sala, int aforo, Edificio edificio) {
		super();
		this.sala = sala;
		this.aforo = aforo;
		this.edificio = edificio;
	}

	public Espacio() {
	}

	public int getId_espacio() {
		return id_espacio;
	}
	public void setId_espacio(int id_espacio) {
		this.id_espacio = id_espacio;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public int getAforo() {
		return aforo;
	}
	public void setAforo(int aforo) {
		this.aforo = aforo;
	}
	public Edificio getEdificio() {
		return edificio;
	}
	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}
		
}
