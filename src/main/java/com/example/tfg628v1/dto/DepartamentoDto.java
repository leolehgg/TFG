package com.example.tfg628v1.dto;

import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartamentoDto {

  private Long id;
  @NonNull
  private String nombre;

  private List<EmpleadoDto> empleados;


}
