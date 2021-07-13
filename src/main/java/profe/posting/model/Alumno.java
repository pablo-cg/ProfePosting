package profe.posting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "alumno")
@Data
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "apellidopaterno")
    private String apellidoPaterno;

    @Column(name = "apellidomaterno")
    private String apellidoMaterno;
    private String telefono;

    @Email
    private String correo;

    private String contrasena;

    @JsonManagedReference
    @OneToMany(mappedBy = "alumno")
    private List<Comentario> comentarios;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "alumno")
//    private List<ListaAlumno> listaAlumnos;
}
