package com.example.proiectPractica.Repository;

import com.example.proiectPractica.Classes.Cont;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContRepository extends JpaRepository<Cont,Long> {

    @Query(value = "SELECT procent_conturi_moneda(?1) FROM dual",nativeQuery = true)
    public float procentConturiMoneda(String moneda);

    @Query(value="SELECT procent_conturi_an(?1) FROM dual",nativeQuery = true)
    public float procentConturiAn(int an);

    @Query(value = "SELECT best_moneda FROM dual",nativeQuery = true)
    public String primaMoneda();

    @Query(value = "SELECT conturi_peste_medie FROM dual", nativeQuery = true)
    public float pesteMedie();
}
