package entity.Identificador;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EntidadRelacionId implements Serializable {
    private Long estudianteId;
    private Long carreraId;

    public EntidadRelacionId() {}

    public EntidadRelacionId(Long estudianteId, Long carreraId) {
        this.estudianteId = estudianteId;
        this.carreraId = carreraId;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Long getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Long carreraId) {
        this.carreraId = carreraId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntidadRelacionId)) return false;
        EntidadRelacionId that = (EntidadRelacionId) o;
        return Objects.equals(estudianteId, that.estudianteId)
                && Objects.equals(carreraId, that.carreraId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estudianteId, carreraId);
    }
}
