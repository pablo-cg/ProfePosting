package profe.posting.model;

import lombok.Getter;
import lombok.Setter;
import profe.posting.enums.RolNombre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Integer idRol;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "nombrerol", unique = true)
    private RolNombre nombreRol;

    public Rol() {
    }

    public Rol(RolNombre nombreRol) {
        this.nombreRol = nombreRol;
    }
}
