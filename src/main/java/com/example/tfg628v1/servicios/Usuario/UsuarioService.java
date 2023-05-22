package com.example.tfg628v1.servicios.Usuario;
import com.example.tfg628v1.entidades.Usuario.Usuario;
import com.example.tfg628v1.repositorios.Usuario.usuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final usuarioRepository repositorio;

    private final PasswordEncoder passwordEncoder;

    public  Usuario findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Usuario buscarPorUsername(String username) {
        return repositorio.findFirstByUsername(username);
    }

    public Usuario save(Usuario u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return repositorio.save(u);
    }

    @Transactional
    public void deleteAll() {repositorio.deleteAllInBatch();}
}