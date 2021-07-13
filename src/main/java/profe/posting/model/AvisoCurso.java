package profe.posting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "avisocurso")
@Data
public class AvisoCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profesor_id")
    private Long idProfesor;

    @Column(name = "areaaprendizaje_id")
    private Long idAreaAprendizaje;

    private String titulo;
    private String detalles;
    private String contacto;

    @Transient
    private float puntuacion;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "areaaprendizaje_id", insertable = false, updatable = false, nullable = false)
    private AreaAprendizaje areaAprendizaje;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profesor_id", insertable = false, updatable = false, nullable = false)
    private Profesor profesor;

    @JsonManagedReference
    @OneToMany(mappedBy = "avisoCurso")
    private List<Comentario> comentarios;

    @JsonManagedReference
    @OneToMany(mappedBy = "avisoCurso")
    private List<ListaAlumno> listaAlumnos;


}
