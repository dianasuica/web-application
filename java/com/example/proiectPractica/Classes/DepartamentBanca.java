package com.example.proiectPractica.Classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departamente_banca")
public class DepartamentBanca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdDepartament;

    private String denumire;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_locatie")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private LocatieBanca locatie;

    @JsonBackReference
    @OneToMany
    @JoinColumn(name = "id_departament")
    private List<Angajat> lista_angajati;


    public DepartamentBanca(Long idDepartament, String denumire, LocatieBanca locatie, List<Angajat> lista_angajati) {
        IdDepartament = idDepartament;
        this.denumire = denumire;
        this.locatie = locatie;
        this.lista_angajati = lista_angajati;
    }

    public DepartamentBanca() {
    }

    public Long getIdDepartament() {
        return IdDepartament;
    }

    public void setIdDepartament(Long idDepartament) {
        IdDepartament = idDepartament;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public LocatieBanca getLocatie() {
        return locatie;
    }

    public void setLocatie(LocatieBanca locatie) {
        this.locatie = locatie;
    }

    public List<Angajat> getLista_angajati() {
        return lista_angajati;
    }

    public void setLista_angajati(List<Angajat> lista_angajati) {
        this.lista_angajati = lista_angajati;
    }

    @Override
    public String toString() {
        String rezultat =
                "Departament: " + this.IdDepartament + " " + this.denumire + this.locatie.getOras();
        if(this.lista_angajati!=null)
            for (Angajat a: lista_angajati
            ) {
                rezultat += " " + a.getNume();
            }
        return rezultat;

    }
}
