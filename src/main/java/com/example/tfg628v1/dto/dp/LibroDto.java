package com.example.tfg628v1.dto.dp;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDto {

    private Long id;
    private String nombre;
    private String autor;
    private String opinion;
}
