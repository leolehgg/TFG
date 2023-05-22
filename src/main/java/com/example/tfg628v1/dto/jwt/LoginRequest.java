package com.example.tfg628v1.dto.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
  @NotBlank
  private String username;

  @NotBlank
  private String password;

}
