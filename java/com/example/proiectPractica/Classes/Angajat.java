package com.example.proiectPractica.Classes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="angajati_banca")
public class Angajat {

    @Id
    private Long IdAng;

    private String nume;

    private String prenume;

    private double salariul;

    private String telefon;

    private int varsta;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="id_departament")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DepartamentBanca departament;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_functie")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private FunctieBanca functie;

    public Angajat(Long idAngajat, String nume, String prenume, double salariul, String telefon, int varsta,DepartamentBanca departament, FunctieBanca functie) {
        IdAng = idAngajat;
        this.nume = nume;
        this.prenume = prenume;
        this.salariul = salariul;
        this.telefon = telefon;
        this.departament = departament;
        this.functie = functie;
        this.varsta = varsta;
    }

    public Angajat() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public double getSalariul() {
        return salariul;
    }

    public void setSalariul(double salariul) {
        this.salariul = salariul;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getVarsta() { return varsta; }

    public void setVarsta(int varsta) { this.varsta = varsta; }

    public DepartamentBanca getDepartament() {
        return departament;
    }

    public void setDepartament(DepartamentBanca departament) {
        this.departament = departament;
    }

    public FunctieBanca getFunctie() {
        return functie;
    }

    public void setFunctie(FunctieBanca functie) {
        this.functie = functie;
    }

    public Long getIdAng() {
        return IdAng;
    }

    public void setIdAng(Long idAng) {
        IdAng = idAng;
    }

    @Override
    public String toString() {
        return this.IdAng + " " + this.nume + " " + this.prenume + " " +
                this.salariul + this.functie.getDenumire() + this.departament.getDenumire();
    }
}
