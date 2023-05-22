package com.example.tfg628v1.dto;

import lombok.*;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpleadoDto {

  private Long id;
  @NonNull
  private String nombre;
  private String email;
  private String telefono;
  private boolean directivo;
  private DepartamentoDto departamento;

}
