package com.example.proiectPractica.Service;

import com.example.proiectPractica.Classes.CheltuieliClienti;
import com.example.proiectPractica.Classes.MedieCheltuieli;
import com.example.proiectPractica.Repository.CheltuieliRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheltuieliService {

    private final CheltuieliRepository cheltuieliRepository;

    public CheltuieliService(CheltuieliRepository cheltuieliRepository){
        this.cheltuieliRepository = cheltuieliRepository;
    }

    public List<CheltuieliClienti> finaAll(){
        return cheltuieliRepository.findAll();
    }

    public MedieCheltuieli findByClient(Long clientId){
        List<CheltuieliClienti> cheltuieliClienti = cheltuieliRepository.getByIdClient(clientId);
        List<Long> medii = new ArrayList<>();
        List<String> luni = new ArrayList<>();
        for(CheltuieliClienti clienti : cheltuieliClienti){
            medii.add(clienti.getMedie());
            luni.add(clienti.getLuna());
        }
        return new MedieCheltuieli(medii,luni);
    }

}
