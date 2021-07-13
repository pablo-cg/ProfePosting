package profe.posting.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import profe.posting.model.AreaAprendizaje;

//ENDPOINT: http://localhost:8081/areaAprendizajes
@Repository
public interface AreaAprendizajeRepository extends CrudRepository<AreaAprendizaje, Long> {
}
