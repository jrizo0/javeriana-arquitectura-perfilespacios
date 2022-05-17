package co.edu.javeriana.as.configuration;

import co.edu.javeriana.as.model.Edificio;
import co.edu.javeriana.as.model.Espacio;
import co.edu.javeriana.as.model.Historial;
import co.edu.javeriana.as.repository.EdificiosRepository;
import co.edu.javeriana.as.repository.EspaciosRepository;
import co.edu.javeriana.as.repository.HistorialRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadData {

    @Bean
    CommandLineRunner initDatabase(EdificiosRepository edificiosRepository, EspaciosRepository espaciosRepository, HistorialRepository historialRepository) {
        return args -> {
            System.out.println("Cargando información...");
            Edificio baron = new Edificio(3, "Barón");
            Edificio cubos = new Edificio(45, "Cubos");
            Espacio salon30 = new Espacio("salon30", 40, baron);
            Espacio salon200 = new Espacio("salon200", 30, cubos);
            Espacio salon201 = new Espacio("salon201", 30, cubos);
            Historial historial1 = new Historial("2022-05-07", "09:00", 23, 20.5, salon30);
            Historial historial2 = new Historial("2022-05-07", "19:00", 30, 25, salon30);
            Historial historial3 = new Historial("2022-05-07", "19:00", 10, 12, salon200);
            Historial historial4 = new Historial("2022-05-07", "15:00", 15, 19, salon201);
            edificiosRepository.save(baron);
            edificiosRepository.save(cubos);
            espaciosRepository.save(salon30);
            espaciosRepository.save(salon200);
            espaciosRepository.save(salon201);
            historialRepository.save(historial1);
            historialRepository.save(historial2);
            historialRepository.save(historial3);
            historialRepository.save(historial4);
            System.out.println("Termina el cargue de información.");
        };
    }
}