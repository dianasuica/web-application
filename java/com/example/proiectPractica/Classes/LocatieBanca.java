package com.example.proiectPractica.Classes;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="locatii_banci")
public class LocatieBanca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long IdLocatie;
    private String oras;
    private String strada;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_locatie")
    private List<DepartamentBanca> departamenteBancaList;

    public LocatieBanca() {
    }

    public LocatieBanca(Long idLocatie, String oras, String strada, List<DepartamentBanca> departamenteBancaList) {
        IdLocatie = idLocatie;
        this.oras = oras;
        this.strada = strada;
        this.departamenteBancaList = departamenteBancaList;
    }

    public Long getIdLocatie() {
        return IdLocatie;
    }

    public void setIdLocatie(Long idLocatie) {
        IdLocatie = idLocatie;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public List<DepartamentBanca> getDepartamenteBancaList() {
        return departamenteBancaList;
    }

    public void setDepartamenteBancaList(List<DepartamentBanca> departamenteBancaList) {
        this.departamenteBancaList = departamenteBancaList;
    }

    @Override
    public String toString() {
        String rezultat=
                "Locatie Banca: " +this.IdLocatie +" " + this.oras + " "+ this.strada;
//        if(this.departamenteBancaList!=null)
//            for (DepartamenteBanca d: departamenteBancaList
//                 ) {
//                rezultat += " " + d.getDenumire();
//
//            }
        return rezultat;

    }
}
