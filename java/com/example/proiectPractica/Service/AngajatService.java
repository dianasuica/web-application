package com.example.proiectPractica.Service;

import com.example.proiectPractica.Classes.Angajat;
import com.example.proiectPractica.Classes.DepartamentBanca;

import com.example.proiectPractica.Classes.MedieVarsta;
import com.example.proiectPractica.Repository.AngajatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AngajatService {

    @Autowired
    AngajatRepository angajatRepository;

    @Autowired
    DataSource dataSource;

    public AngajatService(AngajatRepository angajatRepository) {
        this.angajatRepository = angajatRepository;
    }

    public List<Angajat> findAll()
    {
        return angajatRepository.findAll();
    }

    public String findByDepartament(DepartamentBanca d)
    {
        return angajatRepository.findByDepartament(d);
    }

    public Long procentClienti(Long idAng)
    {
        return angajatRepository.procentClienti(idAng);
    }

    public MedieVarsta getMedieVarsta(){

        List<Object[]> result = angajatRepository.getMedieVarsta();
        List<String> departamente = new ArrayList<>();
        List<BigDecimal> medii = new ArrayList<>();
        if(result != null && !result.isEmpty()){
            for (Object[] object : result) {
                departamente.add((String)object[0]);
                BigDecimal b = (BigDecimal) object[1];
                b = b.setScale(2, BigDecimal.ROUND_UP);
                medii.add(b);
            }
        }
        return new MedieVarsta(departamente,medii);
    }


}
