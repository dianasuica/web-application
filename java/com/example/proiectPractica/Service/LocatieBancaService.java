package com.example.proiectPractica.Service;

import com.example.proiectPractica.Classes.LocatieBanca;
import com.example.proiectPractica.Repository.LocatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class LocatieBancaService {

    @Autowired
    private LocatieRepository locatieRepository;
    @Autowired
    DataSource dataSource;

    public LocatieBancaService(LocatieRepository locatieRepository) {
        this.locatieRepository = locatieRepository;
    }

    public LocatieBancaService() {
    }

    public List<LocatieBanca> listAll()
    {
        return locatieRepository.findAll();

    }

    public List<LocatieBanca> findByOras(String oras)
    {
        return locatieRepository.findByOras(oras);
    }





}
