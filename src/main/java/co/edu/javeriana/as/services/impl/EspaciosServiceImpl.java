package co.edu.javeriana.as.services.impl;

import co.edu.javeriana.as.exceptions.EdificioNotFoundException;
import co.edu.javeriana.as.exceptions.EspacioNotFoundException;
import co.edu.javeriana.as.model.Edificio;
import co.edu.javeriana.as.model.Espacio;
import co.edu.javeriana.as.model.Historial;
import co.edu.javeriana.as.repository.EdificiosRepository;
import co.edu.javeriana.as.repository.EspaciosRepository;
import co.edu.javeriana.as.repository.HistorialRepository;
import co.edu.javeriana.as.services.EspaciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EspaciosServiceImpl implements EspaciosService {
	
	@Autowired
	EspaciosRepository espaciosRepository ;
	@Autowired
	EdificiosRepository edificiosRepository ;
	@Autowired
	HistorialRepository historialRepository ;
	
	 @Override
	 public List<Espacio> getEspacios(){
		 return espaciosRepository.findAll();
	  }

	@Override
	public double getPromedioEnergiaPorFechaActual() {
		String fechaActual = LocalDate.now().toString();
		List<Historial> historialesFechaActual = historialRepository.findByFecha(fechaActual);
		double prom = 0;
		for(Historial historial : historialesFechaActual) {
			prom += historial.getConsumoEnergia();
		}
		prom /= historialesFechaActual.size();
		return prom;
	}

	@Override
	public double getPromedioEnergiaEspacioPorFechaActual(int espacioId) throws EspacioNotFoundException {
		String fechaActual = LocalDate.now().toString();
		Espacio espacio = espaciosRepository.findById(espacioId).orElseThrow(() -> new EspacioNotFoundException(espacioId));;
		List<Historial> historialesFechaActual = historialRepository.findByFechaAndEspacio(fechaActual, espacio);
		double prom = 0;
		for(Historial historial : historialesFechaActual) {
			prom += historial.getConsumoEnergia();
		}
		prom /= historialesFechaActual.size();
		return prom;
	}

	@Override
	public double getPromedioEnergiaEdificioPorFechaActual(int edificioId) throws EdificioNotFoundException{
		String fechaActual = LocalDate.now().toString();
		Edificio edificio = edificiosRepository.findById(edificioId).orElseThrow(() -> new EdificioNotFoundException(edificioId));;
		List<Historial> historialesFechaActual = historialRepository.findByFechaAndEdificio(fechaActual, edificio);
		double prom = 0;
		for(Historial historial : historialesFechaActual) {
			prom += historial.getConsumoEnergia();
		}
		prom /= historialesFechaActual.size();
		return prom;
	}

	@Override
	public double getPromedioAforoPorFechaActual() {
		String fechaActual = LocalDate.now().toString();
		List<Historial> historialesFechaActual = historialRepository.findByFecha(fechaActual);
		double prom = 0;
		for(Historial historial : historialesFechaActual) {
			prom += historial.getCantidadEstudiantes();
		}
		prom /= historialesFechaActual.size();
		return prom;
	}

	@Override
	public double getPromedioAforoEspacioPorFechaActual(int espacioId) throws EspacioNotFoundException {
		String fechaActual = LocalDate.now().toString();
		Espacio espacio = espaciosRepository.findById(espacioId).orElseThrow(() -> new EspacioNotFoundException(espacioId));;
		List<Historial> historialesFechaActual = historialRepository.findByFechaAndEspacio(fechaActual, espacio);
		double prom = 0;
		for(Historial historial : historialesFechaActual) {
			prom += historial.getCantidadEstudiantes();
		}
		prom /= historialesFechaActual.size();
		return prom;
	}

	@Override
	public double getPromedioAforoEdificioPorFechaActual(int edificioId) throws EdificioNotFoundException {
		String fechaActual = LocalDate.now().toString();
		Edificio edificio = edificiosRepository.findById(edificioId).orElseThrow(() -> new EdificioNotFoundException(edificioId));;
		List<Historial> historialesFechaActual = historialRepository.findByFechaAndEdificio(fechaActual, edificio);
		double prom = 0;
		for(Historial historial : historialesFechaActual) {
			prom += historial.getCantidadEstudiantes();
		}
		prom /= historialesFechaActual.size();
		return prom;
	}

}
