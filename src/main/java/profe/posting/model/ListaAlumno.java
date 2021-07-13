package profe.posting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "listaalumno")
@Data
public class ListaAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "profesor_id")
    private Long idProfesor;

    @Column(name = "alumno_id")
    private Long idAlumno;

    @Column(name = "avisocurso_id")
    private Long idAvisoCurso;

    @Column(name = "fechaingreso")
    private Date fechaIngreso;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false, updatable = false, insertable = false)
    private Profesor profesor;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false, insertable = false, updatable = false)
    private Alumno alumno;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "avisocurso_id", updatable = false, insertable = false, nullable = false)
    private AvisoCurso avisoCurso;
}
