package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/")
    public List<Usuario> consultarUsuarios() {
        return (List<Usuario>) usuarioRepository.darUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultarUsuarioPorId(@PathVariable(value = "id") Integer usuarioId) {
        Usuario usuario = usuarioRepository.darUsuarioPorId(usuarioId);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/tipo/{tipoUsuario}")
    public List<Usuario> consultarUsuariosPorTipo(@PathVariable String tipoUsuario) {
        return (List<Usuario>) usuarioRepository.darUsuariosPorTipo(tipoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable(value = "id") Integer usuarioId,
            @RequestBody Usuario usuarioDetalles) {
        Usuario usuario = usuarioRepository.darUsuarioPorId(usuarioId);
        if (usuario != null) {
            usuario.setNombre(usuarioDetalles.getNombre());
            usuario.setUsername(usuarioDetalles.getUsername());
            usuario.setPassword(usuarioDetalles.getPassword());
            usuario.setTipousuario(usuarioDetalles.getTipousuario());
            usuario.setHotel(usuarioDetalles.getHotel());
            Usuario usuarioActualizado = usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuarioActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable(value = "id") Integer usuarioId) {
        Usuario usuario = usuarioRepository.darUsuarioPorId(usuarioId);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
