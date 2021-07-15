package profe.posting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "areaaprendizaje")
@Getter
@Setter
public class AreaAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String imgurl;

    @OneToMany(mappedBy = "areaAprendizaje")
    private List<Curso> cursos;

}
