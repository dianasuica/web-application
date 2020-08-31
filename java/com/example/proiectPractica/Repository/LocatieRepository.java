package com.example.proiectPractica.Repository;

import com.example.proiectPractica.Classes.LocatieBanca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocatieRepository extends JpaRepository<LocatieBanca,Long> {

    public  List<LocatieBanca> findByOras(String oras);

}
