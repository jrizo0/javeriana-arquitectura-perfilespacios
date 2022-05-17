package co.edu.javeriana.as.services;

import co.edu.javeriana.as.exceptions.EdificioNotFoundException;
import co.edu.javeriana.as.exceptions.EspacioNotFoundException;
import co.edu.javeriana.as.model.Espacio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EspaciosService {

	public double getPromedioEnergiaPorFechaActual();
	public double getPromedioEnergiaEspacioPorFechaActual(int espacioId) throws EspacioNotFoundException;
	public double getPromedioEnergiaEdificioPorFechaActual(int edificioId) throws EdificioNotFoundException;
	public double getPromedioAforoPorFechaActual();
	public double getPromedioAforoEspacioPorFechaActual(int espacioId) throws EspacioNotFoundException;
	public double getPromedioAforoEdificioPorFechaActual(int edificioId) throws EdificioNotFoundException;

	public List<Espacio> getEspacios();

}
