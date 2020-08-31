package com.example.proiectPractica.Controllers;

import com.example.proiectPractica.Classes.Angajat;
import com.example.proiectPractica.Classes.DepartamentBanca;
import com.example.proiectPractica.Classes.MedieVarsta;
import com.example.proiectPractica.Service.AngajatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/angajati")
public class AngajatController {


    private final AngajatService angajatService;

    public AngajatController(AngajatService angajatService) {
        this.angajatService = angajatService;
    }

    @RequestMapping("/all")
    public List<Angajat> findAll()
    {
        return angajatService.findAll();
    }

    @RequestMapping("/idDepartament/{d}")
    public List<Angajat> findByDepartament(@PathVariable DepartamentBanca d)
    {
        List<Angajat> lista = angajatService.findAll().stream().filter(x->x.getDepartament() == d).collect(Collectors.toList());
        return lista;
    }

    @GetMapping("/medieVarsta")
    public MedieVarsta findMedieVarsta(){
        return angajatService.getMedieVarsta();
    }

    @RequestMapping("/idDepartament/{d}/procent")
    public String procent(@PathVariable DepartamentBanca d)
    {
        String rezultat="";
        Long total = angajatService.findAll().stream().count();
        Long ang_dep = angajatService.findAll().stream().filter(x->x.getDepartament()==d).count();

        rezultat +=" Procent din totalul angajatilor: " + (ang_dep*100)/total + " %";
        return rezultat;

    }

    @RequestMapping("/{idAng}/procentClienti")
    public String procentClienti(@PathVariable Long idAng)
    {
        float pr_clienti =angajatService.procentClienti(idAng);
        if(pr_clienti > 0)
            return "Angajatul " + angajatService.findAll().stream().filter(x->x.getIdAng()==idAng).findFirst().get().getNume() +" are un procent al clientilor de: "
           + pr_clienti + "%";
        else
            return "Angajatul " + angajatService.findAll().stream().filter(x->x.getIdAng()==idAng).findFirst().get().getNume() + " nu are clienti.";
    }

}
