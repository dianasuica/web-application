package com.example.proiectPractica.Repository;

import com.example.proiectPractica.Classes.DepartamentBanca;
import com.example.proiectPractica.Classes.LocatieBanca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentRepository extends JpaRepository<DepartamentBanca,Long> {

    public List<DepartamentBanca> findByLocatie(LocatieBanca l);

}
