package com.example.proiectPractica.Service;

import com.example.proiectPractica.Classes.DepartamentBanca;
import com.example.proiectPractica.Classes.LocatieBanca;
import com.example.proiectPractica.Repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    @Autowired
    private DataSource dataSource;

    public DepartamentService(DepartamentRepository departamentRepository) {
        this.departamentRepository = departamentRepository;
    }

    public DepartamentService() {
    }

    public List<DepartamentBanca> findAll()
    {
        return departamentRepository.findAll();
    }

    public  List<DepartamentBanca> findByLocatie(LocatieBanca l)
    {
        return departamentRepository.findByLocatie( l);
    }

}
