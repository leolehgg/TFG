package com.example.tfg628v1.controladores;

import com.example.tfg628v1.entidades.DesarrolloPersonal.*;
import com.example.tfg628v1.servicios.DesarrolloPersonal.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Data
@Slf4j
@RequestMapping("/dp")
public class desarrollopersonalController {

    //Importaciones
    private final libroService libroService;
    private final objetivoPersonalService objetivoPersonalService;
    private final rutinaComidasService rutinaComidasService;
    private final tipoComidaService tipoComidaService;
    private final rutinaEjercicioFisicoService rutinaEjercicioFisicoService;
    private final ejercicioService ejercicioService;
    private final comidaService comidaService;


    @ModelAttribute("listaTipoComida")
    public List<TipoComida> listaTipoComida() {
        return tipoComidaService.findAll();
    }
    @ModelAttribute("listaRutinasEF")
    public List<RutinaEjercicioFisico> listaRutinaEF(){
        return rutinaEjercicioFisicoService.findAll();
    }
    @ModelAttribute("listaComidas")
    public List<Comida> listaComidas() {
        return comidaService.findAll();
    }



    @GetMapping({ ""})
    public String dp(Model model) {
        model.addAttribute("listaLibros", libroService.findAll());
        model.addAttribute("listaop", objetivoPersonalService.findAll());
        model.addAttribute("listacomidas", rutinaComidasService.findAll());

        return "DesarrolloPersonal/desarrolloPersonal";
    }


    @GetMapping({ "libro"})
    public String libro(Model model) {
        model.addAttribute("libroForm",new Libro());
        model.addAttribute("listaLibros", libroService.findAll());
        return "DesarrolloPersonal/libro";
    }
    @PostMapping("/libro/submit")
    public String nuevolibro(@Valid @ModelAttribute("libroForm") Libro libro,
                                      BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            log.info("hay errores en el formulario");

            return "DesarrolloPersonal/desarrolloPersonal";
        } else {
            libroService.save(libro);
            return "redirect:/dp/libro";
        }

    }

    @GetMapping("/libro/edit/{id}")
    public String editarLibroForm(@PathVariable long id, Model model) {

       Libro libro = libroService.findById(id);
        if (libro != null) {
            model.addAttribute("libroForm", libro);
            return "DesarrolloPersonal/libro";
        } else {
            return "redirect:/dp/libro";
        }
    }
    @GetMapping("/libro/delete/{id}")
    public String borrarLibro(@PathVariable("id") Long id, Model model) {

        Libro libro = libroService.findById(id);

        if (libro != null)
            libroService.delete(libro);

        return "redirect:/dp/libro";
    }


    @GetMapping({ "objetivoPersonal"})
    public String objetivoPersonal(Model model) {
        model.addAttribute("objetivoPersonalForm",new ObjetivoPersonal());
        model.addAttribute("listaop", objetivoPersonalService.findAll());
        return "DesarrolloPersonal/objetivoPersonal";
    }
    @PostMapping("/objetivoPersonal/submit")
    public String nuevoobjetivoPersonal(@Valid @ModelAttribute("objetivoPersonalForm") ObjetivoPersonal op,
                             BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            log.info("hay errores en el formulario");

            return "DesarrolloPersonal/desarrolloPersonal";
        } else {
            objetivoPersonalService.save(op);
            return "redirect:/dp/objetivoPersonal";
        }

    }

    @GetMapping({ "rutinaComidas"})
    public String rutinaComidas(Model model) {
        model.addAttribute("ComidasForm",new RutinaComidas());
        model.addAttribute("listacomidas", rutinaComidasService.findAll());

        return "DesarrolloPersonal/rutinaComidas";
    }
    @PostMapping("/rutinacomidas/submit")
    public String nuevaRutinaComidas(@Valid @ModelAttribute("ComidasForm") RutinaComidas comidas,
                                        BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            log.info("hay errores en el formulario");

            return "DesarrolloPersonal/desarrolloPersonal";
        } else {
            rutinaComidasService.save(comidas);
            return "redirect:/dp/rutinaComidas";
        }

    }

    @GetMapping({ "rutinaEjercicioFisico"})
    public String rutinaEjercicioFisico(Model model) {
        model.addAttribute("EFForm",new RutinaEjercicioFisico());
        model.addAttribute("EjercicioForm", new Ejercicio());
        model.addAttribute("listaRutinaEjercicioFisico", rutinaEjercicioFisicoService.findAll());
        model.addAttribute("listaEjercicios" , ejercicioService.findAll());
        return "DesarrolloPersonal/rutinaEjercicioFisico";
    }

        @PostMapping("/rutinaEjercicioFisico/submit")
    public String nuevaRutinaEjercicioFisico(@Valid @ModelAttribute("listaRutinaEjercicioFisico") RutinaEjercicioFisico ef,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("hay errores en el formulario");

            return "DesarrolloPersonal/desarrolloPersonal";
        } else {
            rutinaEjercicioFisicoService.save(ef);
            return "redirect:/dp/rutinaEjercicioFisico";
        }
    }

    @PostMapping("/rutinaEjercicioFisico/submitejercicio")
    public String nuevoEjercicio(@Valid @ModelAttribute("listaEjercicios") Ejercicio ef,
                                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("hay errores en el formulario");

            return "DesarrolloPersonal/desarrolloPersonal";
        } else {
            ejercicioService.save(ef);
            return "redirect:/dp/rutinaEjercicioFisico";
        }
    }

}
