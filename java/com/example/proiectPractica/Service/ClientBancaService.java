package com.example.proiectPractica.Service;

import com.example.proiectPractica.Classes.ClientBanca;
import com.example.proiectPractica.Repository.ClientBancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class ClientBancaService {

    @Autowired
    private ClientBancaRepository clientBancaRepository;

    @Autowired
    private DataSource dataSource;

    public ClientBancaService(ClientBancaRepository clientBancaRepository) {
        this.clientBancaRepository = clientBancaRepository;
    }

    public List<ClientBanca> findALL(){
        return clientBancaRepository.findAll();
    }

    public int varstaClient(String nume,String prenume)
    {
        return clientBancaRepository.varstaClient(nume,prenume);
    }

    public Long totalClienti()
    {
        return clientBancaRepository.totalClienti();
    }

    public Long clientiPesteVarsta(int varsta)
    {
        return clientBancaRepository.clientiPesteVarsta(varsta);
    }
}
