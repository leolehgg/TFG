package com.example.tfg628v1.seguridad;

import com.example.tfg628v1.entidades.Usuario.Usuario;
import com.example.tfg628v1.repositorios.Usuario.usuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final usuarioRepository repositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repositorio.findFirstByUsername(username);

		UserBuilder builder = null;

		if (usuario != null) {
			builder = User.withUsername(username);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}

		return builder.build();
	}

}
