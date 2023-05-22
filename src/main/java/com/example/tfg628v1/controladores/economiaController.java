package com.example.tfg628v1.controladores;


import com.example.tfg628v1.entidades.Economia.Transaccion;
import com.example.tfg628v1.servicios.Economia.economiaService;
import com.example.tfg628v1.servicios.Economia.tipoTransaccionService;
import com.example.tfg628v1.servicios.Economia.transaccionService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Data
@Slf4j
@RequestMapping("/economia")
public class economiaController {

    //IMPORTACIONES
    @Autowired
    private economiaService economiaService;
    @Autowired
    private transaccionService transaccionService;
    @Autowired
    private tipoTransaccionService tipoTransaccionService;


    @GetMapping({ ""})
    public String economia(Model model) {

        return "Economia/economia";
    }

    @GetMapping({ "/transaccion"})
    public String transaccion(Model model) {
        model.addAttribute("transaccionForm",new Transaccion());
        model.addAttribute("listaTransacciones", transaccionService.findAll());
        model.addAttribute("listaTipoTransacciones", tipoTransaccionService.findAll());
        return "Economia/transaccion";
    }
    @PostMapping("/transaccion/submit")
    public String nuevaTransaccion(@Valid @ModelAttribute("transaccionForm") Transaccion transaccion,
                                     BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            log.info("hay errores en el formulario");

            return "Economia/economia";
        } else {
            transaccionService.save(transaccion);
            return "redirect:/economia/transaccion";
        }

    }

}
