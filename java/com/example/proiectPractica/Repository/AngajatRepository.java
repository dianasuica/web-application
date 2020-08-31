package com.example.proiectPractica.Repository;

import com.example.proiectPractica.Classes.Angajat;
import com.example.proiectPractica.Classes.DepartamentBanca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AngajatRepository extends JpaRepository<Angajat,Long> {

     String findByDepartament(DepartamentBanca d);

     @Query(value ="SELECT procent_cl(?1) FROM angajati_banca WHERE id_ang=?1",nativeQuery = true)
     Long procentClienti( Long idAng);

     @Query(value = "SELECT  D.DENUMIRE, AVG(A.VARSTA) FROM angajati_banca A inner join DEPARTAMENTE_BANCA D on A.ID_DEPARTAMENT = D.ID_DEPARTAMENT" +
             " group by D.DENUMIRE",nativeQuery = true)
     List<Object[]> getMedieVarsta();

}
