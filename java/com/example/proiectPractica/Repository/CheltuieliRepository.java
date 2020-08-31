package com.example.proiectPractica.Repository;

import com.example.proiectPractica.Classes.CheltuieliClienti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheltuieliRepository extends JpaRepository<CheltuieliClienti,Long> {

    @Query(value = "SELECT * from cheltuieli_clienti where ID_CLIENT = ?1 order by ID_CHELTUIELI asc",nativeQuery = true)
    List<CheltuieliClienti> getByIdClient(Long clientId);

}
