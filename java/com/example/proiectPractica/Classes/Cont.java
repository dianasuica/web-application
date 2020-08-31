package com.example.proiectPractica.Classes;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Conturi")
public class Cont {

    @Id
    private Long idCont;

    private String IBAN;

    private Long suma;

    private String moneda;

    private Date dataStart;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_client")
    private ClientBanca client;

    public Cont(Long idCont, String IBAN, Long suma, String moneda, Date dataStart, ClientBanca client) {
        this.idCont = idCont;
        this.IBAN = IBAN;
        this.suma = suma;
        this.moneda = moneda;
        this.dataStart = dataStart;
        this.client = client;
    }

    public Cont() {
    }

    public Long getIdCont() {
        return idCont;
    }

    public void setIdCont(Long idCont) {
        this.idCont = idCont;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Long getSuma() {
        return suma;
    }

    public void setSuma(Long suma) {
        this.suma = suma;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Date getDataStart() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    public ClientBanca getClient() {
        return client;
    }

    public void setClient(ClientBanca client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return this.idCont + ", " + this.suma + ", " + this.moneda + ", " + this.IBAN;
    }
}
