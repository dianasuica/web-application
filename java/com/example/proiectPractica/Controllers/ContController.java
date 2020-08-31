package com.example.proiectPractica.Controllers;

import com.example.proiectPractica.Classes.Cont;
import com.example.proiectPractica.Service.ContService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/conturi")
public class ContController {


    private final ContService contService;

    public ContController(ContService contService) {
        this.contService = contService;
    }

    @RequestMapping("/all")
    public List<Cont> findAll()
    {
        return contService.findAll();
    }

    @RequestMapping("/procent/{moneda}")
    public String procentConturiMoneda(@PathVariable String moneda)
    {
        return contService.procentConturiMoneda(moneda) + "%";
    }

    @RequestMapping("/procentAn/{an}")
    public String procentConturiAn(@PathVariable int an)
    {
        return contService.procentConturiAn(an) + "%";
    }

    @RequestMapping("/primaMoneda")
    public String primaMoneda()
    {
        return "Cele mai multe conturi au la baza moneda " + contService.primaMoneda() +".";
    }

    @RequestMapping("/pesteMedie")
    public String pesteMedie()
    {
        return "Conturile care depasesc nivelul mediu al sumelor inregistrate sunt in procent de " + contService.pesteMedie() + "%.";
    }
}
