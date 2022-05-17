package co.edu.javeriana.as.model;

import javax.persistence.*;

@Entity
@Table (name="edificios")
public class Edificio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_edificio;
	private int numero;
	private String nombre;
	
	
	public Edificio(int numero, String nombre) {
		super();
		this.numero = numero;
		this.nombre = nombre;
	}
	public Edificio() {}

	public int getId_edificio() {
		return id_edificio;
	}
	public void setId_edificio(int id_edificio) {
		this.id_edificio = id_edificio;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
