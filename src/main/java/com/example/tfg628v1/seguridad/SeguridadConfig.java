package com.example.tfg628v1.seguridad;

import com.example.tfg628v1.seguridad.jwt.JwtAuthEntryPoint;
import com.example.tfg628v1.seguridad.jwt.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadConfig {

  private final UserDetailsService userDetailsService;
  private final JwtAuthEntryPoint jwtAuthEntryPoint;
  private final JwtAuthFilter jwtAuthFilter;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  @Order(1)
  public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
    http
      .antMatcher("/api/**")
      .cors().and().csrf().disable()
      .exceptionHandling()
        .authenticationEntryPoint(jwtAuthEntryPoint)
      .and()
      .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .authorizeRequests()
        .antMatchers("/api/auth/**").permitAll()
        .anyRequest().authenticated();

    http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

  @Bean
  public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
    http
      .cors().and().csrf().disable()
      .authorizeHttpRequests()
      .antMatchers("/", "/webjars/**", "/css/**", "/h2-console/**", "/img/**" ,"/js/**").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin()
      .loginPage("/login")
      .permitAll()
      .and()
      //.rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
      //.and()
      .logout()
      .logoutSuccessUrl("/login?logout").permitAll();

    // Para que funcione el h2-console estas dos líneas son necesarias
    http.headers().frameOptions().disable();

    return http.build();
  }

}
