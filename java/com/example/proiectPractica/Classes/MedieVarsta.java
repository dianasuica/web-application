package com.example.proiectPractica.Classes;

import java.math.BigDecimal;
import java.util.List;

public class MedieVarsta {

    private List<String> departamente;
    private List<BigDecimal> medie;

    public MedieVarsta(List<String> departamente, List<BigDecimal> medie) {
        this.departamente = departamente;
        this.medie = medie;
    }

    public List<String> getDepartamente() {
        return departamente;
    }

    public void setDepartamente(List<String> departamente) {
        this.departamente = departamente;
    }

    public List<BigDecimal> getMedie() {
        return medie;
    }

    public void setMedie(List<BigDecimal> medie) {
        this.medie = medie;
    }
}
