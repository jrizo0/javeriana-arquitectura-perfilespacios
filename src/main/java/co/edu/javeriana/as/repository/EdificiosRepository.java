package co.edu.javeriana.as.repository;

import co.edu.javeriana.as.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificiosRepository extends JpaRepository<Edificio, Integer> {
}
