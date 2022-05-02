package com.cenfotec.bibilotecaapi.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.*;

@Entity
@Table (name = "Hijos")
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private String tipoPlan;

    private String alergias;

    @Column (name = "idAdulto")
    private Long idAdulto;

    private ArrayList<Long> libroList;

    public Hijo(String nombre, String tipoPlan, String alergias) {
        this.nombre = nombre;
        this.tipoPlan = tipoPlan;
        this.alergias = alergias;

    }

    public Hijo() {


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public ArrayList<Long> getLibroList() {
        return libroList;
    }

    public void setLibroList(ArrayList<Long> libroList) {
        this.libroList = libroList;
    }

    public Long getIdAdulto() {
        return idAdulto;
    }

    public void setIdAdulto(Long idAdulto) {
        this.idAdulto = idAdulto;
    }
}

