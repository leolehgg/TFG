package com.example.tfg628v1.controladores;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Data
@Slf4j
@RequestMapping("/diario")
public class diarioController {

    @GetMapping({ ""})
    public String dp(Model model) {

        return "Diario/diario";
    }

    @GetMapping({ "evento"})
    public String evento(Model model) {

        return "Diario/evento";
    }

    @GetMapping({ "seguimientoDeHabitos"})
    public String seguimientoDeHabitos(Model model) {

        return "Diario/seguimientoDeHabitos";
    }

    @GetMapping({ "tarea"})
    public String tarea(Model model) {

        return "Diario/tarea";
    }


}
