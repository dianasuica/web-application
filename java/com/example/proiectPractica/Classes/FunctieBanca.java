package com.example.proiectPractica.Classes;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="functii_banca")
public class FunctieBanca {

    @Id
    private Long IdFunctie;
    private String denumire;
    private double salariuMin;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_functie")
    private List<Angajat> lista_angajati;

    public FunctieBanca(Long idFunctie, String denumire, double salariuMin, List<Angajat> lista_angajati) {
        IdFunctie = idFunctie;
        this.denumire = denumire;
        this.salariuMin = salariuMin;
        this.lista_angajati = lista_angajati;
    }

    public FunctieBanca() {
    }

    public Long getIdFunctie() {
        return IdFunctie;
    }

    public void setIdFunctie(Long idFunctie) {
        IdFunctie = idFunctie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public double getSalariuMin() {
        return salariuMin;
    }

    public void setSalariuMin(double salariuMin) {
        this.salariuMin = salariuMin;
    }

    public List<Angajat> getLista_angajati() {
        return lista_angajati;
    }

    public void setLista_angajati(List<Angajat> lista_angajati) {
        this.lista_angajati = lista_angajati;
    }

    @Override
    public String toString() {
        String rezultat = this.IdFunctie + " " + this.denumire + " " +this.salariuMin;
//        if(lista_angajati!=null)
//            for (Angajat a : lista_angajati
//                 ) {
//
//                rezultat += " " + a.getNume();
//
//            }
        return rezultat;
    }
}
