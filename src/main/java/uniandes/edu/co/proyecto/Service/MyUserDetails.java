package uniandes.edu.co.proyecto.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import uniandes.edu.co.proyecto.modelo.Usuario;

import java.util.Collection;
import java.util.Collections;

public class MyUserDetails implements UserDetails {

    private final Usuario usuario;

    public MyUserDetails(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aquí debes convertir los roles/permisos de tu usuario a objetos GrantedAuthority
        // Ejemplo simple si tienes una propiedad "roles" como una lista de String
        return Collections.emptyList(); // Implementar según la estructura de tu usuario
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    // Implementa los siguientes métodos según las propiedades de tu clase Usuario
    @Override
    public boolean isAccountNonExpired() {
        return true; // o según tu lógica de negocio
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // o según tu lógica de negocio
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // o según tu lógica de negocio
    }

    @Override
    public boolean isEnabled() {
        return true; // o según tu lógica de negocio
    }
}
