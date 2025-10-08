package repository;

import entity.Carrera;
import DTO.CarerraDTO;
import java.util.List;

public interface CarreraRepository extends Repository<Carrera> {
    List<CarerraDTO> obtenerCarrerasConEstudiantesInscriptos();
}
