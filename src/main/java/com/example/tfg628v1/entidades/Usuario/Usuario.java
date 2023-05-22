package com.example.tfg628v1.entidades.Usuario;

import com.example.tfg628v1.entidades.DesarrolloPersonal.DesarrolloPersonal;
import com.example.tfg628v1.entidades.Diario.Diario;
import com.example.tfg628v1.entidades.Economia.Economía;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  private String password;

  private String role;

  @CreatedDate
  private LocalDateTime fechaAlta;

  @OneToOne(mappedBy = "usuario" , cascade = CascadeType.ALL)
  private DesarrolloPersonal desarrolloPersonal;
  @OneToOne(mappedBy = "usuario" , cascade = CascadeType.ALL)
  private Diario diario;
  @OneToOne(mappedBy = "usuario" , cascade = CascadeType.ALL)
  private Economía economía;

}

