package com.example.tfg628v1.entidades.Economia;

import com.example.tfg628v1.entidades.DesarrolloPersonal.RutinaComidas;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class TipoTransaccion {

    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    private String nombre;

    @OneToMany(mappedBy = "tipoTransaccion" , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Transaccion> tipoTransaccion = new ArrayList<>();


}
