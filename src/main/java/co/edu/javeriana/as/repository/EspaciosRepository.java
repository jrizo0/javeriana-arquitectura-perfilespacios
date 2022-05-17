package co.edu.javeriana.as.repository;

import co.edu.javeriana.as.model.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspaciosRepository extends JpaRepository<Espacio, Integer> {
}