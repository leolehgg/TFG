package com.example.tfg628v1.config;

import com.example.tfg628v1.entidades.DesarrolloPersonal.*;
import com.example.tfg628v1.entidades.Economia.TipoTransaccion;
import com.example.tfg628v1.entidades.Economia.Transaccion;
import com.example.tfg628v1.entidades.Usuario.Usuario;
import com.example.tfg628v1.servicios.DesarrolloPersonal.*;
import com.example.tfg628v1.servicios.Economia.tipoTransaccionService;
import com.example.tfg628v1.servicios.Economia.transaccionService;
import com.example.tfg628v1.servicios.Usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
@Service
public class InitialDataConfiguration {

    //Importaciones
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private tipoComidaService tipoComidaService;
    @Autowired
    private libroService libroService;
    @Autowired
    private objetivoPersonalService objetivoPersonalService;
    @Autowired
    private ejercicioService ejercicioService;
    @Autowired
    private rutinaEjercicioFisicoService rutinaEjercicioFisicoService;
    @Autowired
    private transaccionService transaccionService;
    @Autowired
    private tipoTransaccionService tipoTransaccionService;
    @Autowired
    private rutinaComidasService rutinaComidasService;
    @Autowired
    private comidaService comidaService;





    @PostConstruct
    public void initUsuarios() {
        usuarioService.deleteAll();

        Usuario usuario1 = Usuario.builder()
                .username("user").password("user").role("ROLE_USER").build();
        usuarioService.save(usuario1);

        Usuario usuario2 = Usuario.builder()
                .username("admin").password("admin").role("ROLE_ADMIN").build();
        usuarioService.save(usuario2);
    }

    @PostConstruct
    public void initLibros(){
        libroService.deleteAll();
        objetivoPersonalService.deleteAll();

        Libro libro1 = Libro.builder().nombre("UN CAFÉ A SOLAS").autor("Miguel Angel Montero").opinion("Una novela \"emocional\", que despertará sentimientos escondidos y ...").build();
        Libro libro2 = Libro.builder().nombre("Todo arde").autor("Juan Gómez-Jurado").opinion("Después de todo lo que ha pasado con la trilogía Reina Roja, sólo ...").build();
        Libro libro3 = Libro.builder().nombre("La paciente silenciosa ").autor("Alex Michaelides").opinion("Al principio he de reconocer que es un poco liosa ...").build();

        ObjetivoPersonal op1 = ObjetivoPersonal.builder().nombre("aaa").descripcion("aaa").alcanzado(true).build();
        ObjetivoPersonal op2 = ObjetivoPersonal.builder().nombre("bbb").descripcion("bbb").alcanzado(true).build();
        ObjetivoPersonal op3 = ObjetivoPersonal.builder().nombre("ccc").descripcion("ccc").alcanzado(false).build();

        libroService.saveAll(Arrays.asList(libro1,libro2,libro3));
        objetivoPersonalService.saveAll(Arrays.asList(op1,op2,op3));

    }

    @PostConstruct
    public void initEjercicioFisico() {
        ejercicioService.deleteAll();
        rutinaEjercicioFisicoService.deleteAll();


        RutinaEjercicioFisico r1 = RutinaEjercicioFisico.builder().nombre("Dia de pecho").build();
        RutinaEjercicioFisico r2 = RutinaEjercicioFisico.builder().nombre("Dia de pierna").build();

        rutinaEjercicioFisicoService.saveAll(Arrays.asList(r1, r2));
        Ejercicio ejercicio5 = Ejercicio.builder().nombreEjercicio("Sentadilla bulgara").series(4).repeticiones(20).musculo("femoral").rutinaEjercicioFisico(r2).build();

        Ejercicio ejercicio1 = Ejercicio.builder().nombreEjercicio("Press banca").series(4).repeticiones(8).musculo("pecho").rutinaEjercicioFisico(r1).build();
        Ejercicio ejercicio2 = Ejercicio.builder().nombreEjercicio("press banca").series(4).repeticiones(10).musculo("hombro").rutinaEjercicioFisico(r1).build();
        Ejercicio ejercicio3 = Ejercicio.builder().nombreEjercicio("sentadilla").series(4).repeticiones(8).musculo("pierna").rutinaEjercicioFisico(r2).build();
        Ejercicio ejercicio4 = Ejercicio.builder().nombreEjercicio("gemelo").series(4).repeticiones(20).musculo("gemelo").rutinaEjercicioFisico(r2).build();

        ejercicioService.saveAll(Arrays.asList(ejercicio5, ejercicio1,ejercicio2,ejercicio3,ejercicio4));

    }

    @PostConstruct
    public void initEconomia() {
        transaccionService.deleteAll();
        tipoTransaccionService.deleteAll();

        TipoTransaccion tt1 = TipoTransaccion.builder().nombre("D").build();
        TipoTransaccion tt2 = TipoTransaccion.builder().nombre("R").build();
        Transaccion t1 = Transaccion.builder().nombre("s").fecha(LocalDate.of(2020,2,2)).descripcion("blablabla").tipoTransaccion(tt1).build();

        tipoTransaccionService.save(tt1);
        tipoTransaccionService.save(tt2);
        transaccionService.save(t1);
    }


    @PostConstruct
    public void initComida() {
        comidaService.deleteAll();
        rutinaComidasService.deleteAll();
        tipoComidaService.deleteAll();


        TipoComida tp1 = TipoComida.builder().nombre("Carne").build();
        TipoComida tp2 = TipoComida.builder().nombre("Pescado").build();
        tipoComidaService.save(tp1);
        tipoComidaService.save(tp2);

        RutinaComidas rutina1 = RutinaComidas.builder()
                .nombre("Rutina 1")
                .descripcion("Descripción de Rutina 1")
                .calorias(500)
                .tipoComida(tp1)
                .build();

        RutinaComidas rutina2 = RutinaComidas.builder()
                .nombre("Rutina 2")
                .descripcion("Descripción de Rutina 2")
                .calorias(800)
                .tipoComida(tp2)
                .build();
        rutinaComidasService.save(rutina1);
        rutinaComidasService.save(rutina2);


        Comida comida1 = Comida.builder()
                .nombre("Comida 1")
                .rutinacomida(rutina1)
                .build();

        Comida comida2 = Comida.builder()
                .nombre("Comida 2")
                .rutinacomida(rutina1)
                .build();

        Comida comida3 = Comida.builder()
                .nombre("Comida 3")
                .rutinacomida(rutina2)
                .build();
         comidaService.save(comida1);
         comidaService.save(comida2);
         comidaService.save(comida3);





    }

}
