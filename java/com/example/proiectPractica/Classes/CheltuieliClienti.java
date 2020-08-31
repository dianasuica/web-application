package com.example.proiectPractica.Classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "cheltuieli_clienti")
public class CheltuieliClienti {

    @Id
    private long idCheltuieli;

    @Column(name = "ID_CLIENT")
    private long idClient;

    @Column(name = "MEDIE")
    private long medie;

    @Column(name = "LUNA")
    private String luna;

    @Column(name = "AN")
    private long an;

    public CheltuieliClienti(){

    }

    public CheltuieliClienti(long idCheltuieli, long idClient, long medie, String luna, long an) {
        this.idCheltuieli = idCheltuieli;
        this.idClient = idClient;
        this.medie = medie;
        this.luna = luna;
        this.an = an;
    }

    public long getIdCheltuieli() {
        return idCheltuieli;
    }

    public void setIdCheltuieli(long idCheltuieli) {
        this.idCheltuieli = idCheltuieli;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public long getMedie() {
        return medie;
    }

    public void setMedie(long medie) {
        this.medie = medie;
    }

    public String getLuna() {
        return luna;
    }

    public void setLuna(String luna) {
        this.luna = luna;
    }

    public long getAn() {
        return an;
    }

    public void setAn(long an) {
        this.an = an;
    }
}
