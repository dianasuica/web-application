package com.example.proiectPractica.Controllers;

import com.example.proiectPractica.Classes.CheltuieliClienti;
import com.example.proiectPractica.Classes.MedieCheltuieli;
import com.example.proiectPractica.Service.CheltuieliService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cheltuieli")
public class CheltuieliController {

    private final CheltuieliService cheltuieliService;

    public CheltuieliController(CheltuieliService cheltuieliService){
        this.cheltuieliService = cheltuieliService;
    }

    @GetMapping("/all")
    public List<CheltuieliClienti> findAll(){
        return cheltuieliService.finaAll();
    }

    @GetMapping("/medie/{clientId}")
    public MedieCheltuieli getMedii(@PathVariable long clientId){
        return cheltuieliService.findByClient(clientId);
    }
}
