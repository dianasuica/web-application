package com.example.proiectPractica.Service;

import com.example.proiectPractica.Classes.Cont;
import com.example.proiectPractica.Repository.ContRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class ContService {

    @Autowired
    ContRepository contRepository;

    @Autowired
    DataSource dataSource;

    public ContService(ContRepository contRepository) {
        this.contRepository = contRepository;
    }

    public List<Cont> findAll()
    {
        return contRepository.findAll();
    }

    public float procentConturiMoneda(String moneda)
    {
        return contRepository.procentConturiMoneda(moneda);
    }

    public float procentConturiAn(int an)
    {
       return contRepository.procentConturiAn(an);
    }

    public String primaMoneda()
    {
        return contRepository.primaMoneda();
    }

    public float pesteMedie()
    {
        return contRepository.pesteMedie();
    }
}
