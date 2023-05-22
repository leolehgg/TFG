package com.example.tfg628v1.entidades.DesarrolloPersonal;

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
public class TipoComida {

    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    private String nombre;

    @OneToMany(mappedBy = "tipoComida" , cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<RutinaComidas> rutinaComidas = new ArrayList<>();

    public void addCOmida (RutinaComidas e) {
        rutinaComidas.add(e);
        e.setTipoComida(this);
    }

    public void removeZapatilla (RutinaComidas e) {
        rutinaComidas.remove(e);
        e.setTipoComida(null);
    }
}
