package profe.posting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "areaaprendizaje")
@Data
public class AreaAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String imgurl;

    @JsonManagedReference
    @OneToMany(mappedBy = "areaAprendizaje")
    private List<AvisoCurso> avisoCursos;

}
