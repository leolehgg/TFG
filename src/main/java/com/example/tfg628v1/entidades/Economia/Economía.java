package com.example.tfg628v1.entidades.Economia;

import com.example.tfg628v1.entidades.DesarrolloPersonal.RutinaComidas;
import com.example.tfg628v1.entidades.Usuario.Usuario;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Economía {

    @Id
    @GeneratedValue
    private long id;
    private long saldo;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(unique = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "economia", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Transaccion> transacciones = new ArrayList<>();
    public void addrutinaComida (Transaccion e) {
        transacciones.add(e);
        e.setEconomia(this);
    }
    public void removerutinaComida(Transaccion e) {
        transacciones.remove(e);
        e.setEconomia(null);
    }

}
