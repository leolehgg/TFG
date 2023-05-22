package com.example.tfg628v1.entidades.Diario;

import com.example.tfg628v1.entidades.Economia.Economía;
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
public class Evento {

    @Id
    @GeneratedValue
    private long id;
    private String titulo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fecha;
    private String lugar;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private Diario diario;

}
