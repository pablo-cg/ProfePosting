package profe.posting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comentario")
@Getter
@Setter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "curso_id")
    private Long idCurso;

    @Column(name = "usuarioalumno_id")
    private Long idUsuarioAlumno;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date hora;
    private Integer puntuacion;
    private String comentario;

    @Column(name = "esvalido")
    private Boolean esValido;

    @ManyToOne
    @JoinColumn(name = "usuarioalumno_id", updatable = false, insertable = false, nullable = false)
    private Usuario usuarioAlumno;

    @ManyToOne
    @JoinColumn(name = "curso_id", updatable = false, insertable = false, nullable = false)
    private Curso curso;
}
