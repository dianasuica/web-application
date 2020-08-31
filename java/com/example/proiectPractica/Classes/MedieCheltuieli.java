package com.example.proiectPractica.Classes;

import java.math.BigDecimal;
import java.util.List;

public class MedieCheltuieli {

    private List<Long> medii;
    private List<String> luni;

    public MedieCheltuieli(List<Long> medii, List<String> luni) {
        this.medii = medii;
        this.luni = luni;
    }

    public List<Long> getMedii() {
        return medii;
    }

    public void setMedii(List<Long> medii) {
        this.medii = medii;
    }

    public List<String> getLuni() {
        return luni;
    }

    public void setLuni(List<String> luni) {
        this.luni = luni;
    }
}
