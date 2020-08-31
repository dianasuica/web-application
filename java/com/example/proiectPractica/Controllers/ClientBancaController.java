package com.example.proiectPractica.Controllers;

import com.example.proiectPractica.Classes.ClientBanca;
import com.example.proiectPractica.Service.ClientBancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clienti")
public class ClientBancaController {

    private final ClientBancaService clientBancaService;

    public ClientBancaController(ClientBancaService clientBancaService) {
        this.clientBancaService = clientBancaService;
    }

    @RequestMapping("/all")
    public List<ClientBanca> findALL()
    {
        return clientBancaService.findALL();
    }

    @RequestMapping("/varsta/{nume}/{prenume}")
    public int varstaClient(@PathVariable String nume, @PathVariable String prenume)
    {
        return clientBancaService.varstaClient(nume,prenume);
    }

    @RequestMapping("/procentPesteVarsta/{varsta}")
    public String procentClientiPeste(@PathVariable int varsta)
    {
        float procent = (clientBancaService.clientiPesteVarsta(varsta)*100)/ clientBancaService.totalClienti();
        if(procent!=0)
           return "Procentul de clienti peste varsta de " + varsta + ": " + procent + "%";
        else
            return "Nu exista clienti peste aceasta varsta.";
    }
}
