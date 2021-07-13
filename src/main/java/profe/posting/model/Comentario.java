package profe.posting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "alumno_id")
    private Long idAlumno;

    @Column(name = "avisocurso_id")
    private Long idAvisoCurso;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date hora;
    private Integer puntuacion;
    private String comentario;

    @Column(name = "esvalido")
    private Boolean esValido;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false, insertable = false, updatable = false)
    private Alumno alumno;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "avisocurso_id", updatable = false, insertable = false, nullable = false)
    private AvisoCurso avisoCurso;
}
