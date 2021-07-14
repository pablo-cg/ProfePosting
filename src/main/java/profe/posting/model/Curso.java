package profe.posting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curso")
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuarioprofesor_id")
    private Long idUsuarioProfesor;

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

    @ManyToOne
    @JoinColumn(name = "usuarioprofesor_id", insertable = false, updatable = false, nullable = false)
    private Usuario usuarioProfesor;

    @JsonManagedReference
    @OneToMany(mappedBy = "curso")
    private List<Comentario> comentarios;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "curso")
//    private List<ListaAlumno> listaAlumnos;

}
