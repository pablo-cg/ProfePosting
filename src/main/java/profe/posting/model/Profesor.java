package profe.posting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "profesor")
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "apellidopaterno")
    private String apellidoPaterno;

    @Column(name = "apellidomaterno")
    private String apellidoMaterno;

    @Email
    private String correo;

    private String contrasena;

    @JsonManagedReference
    @OneToMany(mappedBy = "profesor")
    private List<AvisoCurso> avisoCursos;

    @JsonManagedReference
    @OneToMany(mappedBy = "profesor")
    private List<ListaAlumno> listaAlumnos;

}
