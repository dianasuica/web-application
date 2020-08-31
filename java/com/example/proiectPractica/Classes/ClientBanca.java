package com.example.proiectPractica.Classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="clienti_banca")
public class ClientBanca {

    @Id
    private Long idClient;

    private String nume;

    private String prenume;

    private String CNP;

    @JsonManagedReference
    @OneToMany
    @JoinColumn(name="id_client")
    private List<Cont> lista_conturi;


    public ClientBanca(Long idClient, String nume, String prenume, String CNP, List<Cont> lista_conturi) {
        this.idClient = idClient;
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.lista_conturi = lista_conturi;
    }


    public ClientBanca() {
    }

    public Long getIdClient() {
        return idClient;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
}
