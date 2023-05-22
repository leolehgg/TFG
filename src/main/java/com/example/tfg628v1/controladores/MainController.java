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
@RequestMapping("/main")
public class MainController {

    @GetMapping({ "home"})
    public String Home(Model model) {

        return "home/home";
    }



}
