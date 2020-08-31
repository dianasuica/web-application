package com.example.proiectPractica.Controllers;


import com.example.proiectPractica.Classes.LocatieBanca;
import com.example.proiectPractica.Service.LocatieBancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/locatii")
public class LocatieBancaController {

    private final LocatieBancaService ls;

    public LocatieBancaController(LocatieBancaService ls) {
        this.ls = ls;
    }

    @GetMapping("/all")
    public List<LocatieBanca> listAll()
    {
        return ls.listAll();
    }

    @GetMapping("/{oras}")
    public List<LocatieBanca> findByOras(@PathVariable String oras)
    {
        return ls.findByOras(oras);
    }
}
