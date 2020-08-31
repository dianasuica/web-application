package com.example.proiectPractica.Repository;

import com.example.proiectPractica.Classes.ClientBanca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientBancaRepository extends JpaRepository<ClientBanca,Long> {

    @Query(value = "SELECT varsta_client(?1,?2) FROM clienti_banca WHERE UPPER(nume)=UPPER(?1) AND UPPER(prenume)=UPPER(?2)",nativeQuery = true)
    public int varstaClient(String numeClient,String prenumeClient);

    @Query(value = "SELECT numar_total FROM dual",nativeQuery = true)
    public Long totalClienti();

    @Query(value = "SELECT client_cu_varsta(?1) FROM dual",nativeQuery = true)
    public Long clientiPesteVarsta(int varsta);

}
