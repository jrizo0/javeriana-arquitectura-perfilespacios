package co.edu.javeriana.as.repository;

import co.edu.javeriana.as.model.Edificio;
import co.edu.javeriana.as.model.Espacio;
import co.edu.javeriana.as.model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer> {
	@Query("SELECT h FROM Historial h WHERE h.fecha = ?1")
	public List<Historial> findByFecha(String fecha);

	@Query("SELECT h FROM Historial h WHERE h.fecha = ?1 AND h.espacio = ?2")
	public List<Historial> findByFechaAndEspacio(String fecha, Espacio espacio);

	@Query("SELECT h FROM Historial h WHERE h.fecha = ?1 AND h.espacio.edificio = ?2")
	public List<Historial> findByFechaAndEdificio(String fecha, Edificio edificio);
}