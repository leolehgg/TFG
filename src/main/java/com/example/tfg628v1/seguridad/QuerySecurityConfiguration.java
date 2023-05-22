package com.example.tfg628v1.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

@EnableMethodSecurity(prePostEnabled = true)
public class QuerySecurityConfiguration {
  @Bean
  SecurityEvaluationContextExtension securityEvaluationContextExtension() {
    return new SecurityEvaluationContextExtension();
  }
}
