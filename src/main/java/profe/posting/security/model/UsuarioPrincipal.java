package profe.posting.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import profe.posting.model.Usuario;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {

    private Long idUsuario;
    private String correo;
    private String contrasena;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(Long idUsuario, String correo, String contrasena, Collection<? extends GrantedAuthority> authorities) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getNombreRol().name()))
                        .collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getIdUsuario(), usuario.getCorreo(), usuario.getContrasena(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
}
