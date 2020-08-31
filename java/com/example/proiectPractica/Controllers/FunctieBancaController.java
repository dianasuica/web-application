package com.example.proiectPractica.Controllers;

import com.example.proiectPractica.Classes.FunctieBanca;
import com.example.proiectPractica.Service.FunctieBancaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/functii")
public class FunctieBancaController {

    private final FunctieBancaService functieBancaService;

    public FunctieBancaController(FunctieBancaService functieBancaService) {
        this.functieBancaService = functieBancaService;
    }

    @GetMapping("/all")
    public List<FunctieBanca> findAll()
    {
       return functieBancaService.findAll();
    }

}
