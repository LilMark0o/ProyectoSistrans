package uniandes.edu.co.proyecto.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario authenticate(String username, String password) {
        Usuario usuario = usuarioRepository.findUserByUsername(username);
        if (usuario != null && usuario.getPassword().equals(password)) {

            return usuario;
        }
        return null;
    }
}


