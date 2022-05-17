package co.edu.javeriana.as.rest;

import co.edu.javeriana.as.exceptions.EdificioNotFoundException;
import co.edu.javeriana.as.exceptions.EspacioNotFoundException;
import co.edu.javeriana.as.services.EspaciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
//@RequestMapping("espacios")
public class EspaciosController {

    @Autowired
    private EspaciosService espaciosService;

    @GetMapping("holamundo")
    public String saludar() {
        return "hola";
    }

    @GetMapping("promEnergiaFechaActual")
    public String promEnergiaFechaActual() {
        String fechaActual = LocalDate.now().toString();
        double prom = espaciosService.getPromedioEnergiaPorFechaActual();
        return "{\"fecha\": " + fechaActual + ", \"promedioEnergia: \"" + prom + "}";
    }

    @GetMapping("promEnergiaFechaActualEspacio")
    public String promEnergiaFechaActualEspacio(@RequestParam("id") int idEspacio) {
        try {
            String fechaActual = LocalDate.now().toString();
            double prom = espaciosService.getPromedioEnergiaEspacioPorFechaActual(idEspacio);
            return "{\"fecha\": " + fechaActual + ", \"idEspacio: \"" + idEspacio + ", \"promedioEnergia: \"" + prom + "}";
        }
        catch (EspacioNotFoundException exc) {
            return new ResponseEntity<Object>("Espacio not found", new HttpHeaders(), HttpStatus.NOT_FOUND).toString();
        }
    }

    @GetMapping("promEnergiaFechaActualEdificio")
    public String promEnergiaFechaActualEdificio(@RequestParam("id") int idEdificio) {
        try {
            String fechaActual = LocalDate.now().toString();
            double prom = espaciosService.getPromedioEnergiaEdificioPorFechaActual(idEdificio);
            return "{\"fecha\": " + fechaActual + ", \"idEdificio: \"" + idEdificio + ", \"promedioEnergia: \"" + prom + "}";
        }
        catch (EdificioNotFoundException exc) {
            return new ResponseEntity<Object>("Edificio not found", new HttpHeaders(), HttpStatus.NOT_FOUND).toString();
        }
    }

    @GetMapping("promAforoFechaActual")
    public String promEstudiantesFechaActual() {
        String fechaActual = LocalDate.now().toString();
        double prom = espaciosService.getPromedioAforoPorFechaActual();
        return "{\"fecha\": " + fechaActual + ", \"promedioAforo: \"" + prom + "}";
    }

    @GetMapping("promAforoFechaActualEspacio")
    public String promAforoFechaActualEspacio(@RequestParam("id") int idEspacio) {
        try {
            String fechaActual = LocalDate.now().toString();
            double prom = espaciosService.getPromedioAforoEspacioPorFechaActual(idEspacio);
            return "{\"fecha\": " + fechaActual + ", \"idEspacio: \"" + idEspacio + ", \"promedioAforo: \"" + prom + "}";
        }
        catch (EspacioNotFoundException exc) {
            return new ResponseEntity<Object>("Espacio not found", new HttpHeaders(), HttpStatus.NOT_FOUND).toString();
        }
    }

    @GetMapping("promAforoFechaActualEdificio")
    public String promdiantesFechaActualEdificio(@RequestParam("id") int idEdificio) {
        try {
            String fechaActual = LocalDate.now().toString();
            double prom = espaciosService.getPromedioAforoEdificioPorFechaActual(idEdificio);
            return "{\"fecha\": " + fechaActual + ", \"idEdificio: \"" + idEdificio + ", \"promedioAforo: \"" + prom + "}";
        }
        catch (EdificioNotFoundException exc) {
            return new ResponseEntity<Object>("Edificio not found", new HttpHeaders(), HttpStatus.NOT_FOUND).toString();
        }
    }
}