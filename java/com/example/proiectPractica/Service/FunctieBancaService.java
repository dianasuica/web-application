package com.example.proiectPractica.Service;

import com.example.proiectPractica.Classes.FunctieBanca;
import com.example.proiectPractica.Repository.FunctieBancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class FunctieBancaService {

    @Autowired
    private FunctieBancaRepository functieBancaRepository;

    @Autowired
    private DataSource dataSource;

    public FunctieBancaService(FunctieBancaRepository functieBancaRepository) {
        this.functieBancaRepository = functieBancaRepository;
    }

    public List<FunctieBanca> findAll()
    {
        return functieBancaRepository.findAll();
    }


}
