package co.edu.javeriana.as.model;

import javax.persistence.*;

@Entity
@Table (name="historial")
public class Historial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  id_historial;
	private String fecha;
	private String hora;
	private int cantidadEstudiantes;
	private double consumoEnergia;
	@OneToOne
	@JoinColumn(name="id_espacio")
	private Espacio espacio;

	public Historial(String fecha, String hora, int cantidadEstudiantes, double consumoEnergia, Espacio espacio) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.cantidadEstudiantes = cantidadEstudiantes;
		this.consumoEnergia = consumoEnergia;
		this.espacio = espacio;
	}
	public Historial() {}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getConsumoEnergia() {
		return consumoEnergia;
	}
	public void setConsumoEnergia(double consumoEnergia) {
		this.consumoEnergia = consumoEnergia;
	}
	public Espacio getEspacio() {
		return espacio;
	}
	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}
	public int getId_historial() {
		return id_historial;
	}
	public void setId_historial(int id_historial) {
		this.id_historial = id_historial;
	}
	public int getCantidadEstudiantes() {
		return cantidadEstudiantes;
	}
	public void setCantidadEstudiantes(int cantidadEstudiantes) {
		this.cantidadEstudiantes = cantidadEstudiantes;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}
