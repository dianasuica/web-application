package com.example.proiectPractica.Controllers;


import com.example.proiectPractica.Classes.DepartamentBanca;
import com.example.proiectPractica.Classes.LocatieBanca;
import com.example.proiectPractica.Service.DepartamentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/departamente")
public class DepartamentController {


    private final DepartamentService departamentService;

    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @RequestMapping("/all")
    public List<DepartamentBanca> findAll()
    {
        return departamentService.findAll();
    }

    @RequestMapping("/{l}")
    public List<DepartamentBanca> findByLocatie(@PathVariable LocatieBanca l)
    {
        return departamentService.findByLocatie(l);
    }


}
