package com.example.tfg628v1.entidades.Economia;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Transaccion {

    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fecha;
    private String descripcion;
    private long cantidad;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private Economía economia;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private TipoTransaccion tipoTransaccion;

}
