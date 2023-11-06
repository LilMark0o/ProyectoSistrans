package uniandes.edu.co.proyecto.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Inyecta tu AuthenticationService y cualquier otro bean necesario aquí
    @Lazy
    private final UserDetailsService userDetailsService;


   


    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
        
        // ...
    

        @Bean
        public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository) {
            return username -> {
                Usuario usuario = usuarioRepository.findUserByUsername(username);
                if (usuario != null) {
                    // Obtener el único rol del usuario
                    String roleName = usuario.getTipoUsuario().getNombre().toUpperCase();
                    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + roleName);
        
                    UserDetails userDetails = User.withUsername(usuario.getUsername())
                            .password(usuario.getPassword()) // No necesitas encriptar la contraseña aquí si ya está encriptada
                            .authorities(authority) // Asignas la única autoridad
                            .build();
                    return userDetails;
                } else {
                    throw new UsernameNotFoundException("Usuario no encontrado");
                }
            };
        }
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
        }


    //     @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeHttpRequests((authorize) -> authorize
    //             .requestMatchers("/login").permitAll()
    //             .anyRequest().authenticated()
    //         )
    //         .formLogin((formLogin) -> formLogin
    //             .loginPage("/login")
    //             .loginProcessingUrl("/login")
    //             .defaultSuccessUrl("/", true)
    //             .failureUrl("/login?error=true")
    //             .permitAll()
    //         )
    //         .logout((logout) -> logout
    //             .logoutUrl("/logout")
    //             .logoutSuccessUrl("/login?logout=true")
    //             .permitAll()
    //         );

    //     return http.build();
    // }

   
}
