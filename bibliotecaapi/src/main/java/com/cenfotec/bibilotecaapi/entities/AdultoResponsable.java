package com.cenfotec.bibilotecaapi.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
@Entity

@Table (name = "AdultosR")
public class AdultoResponsable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "nombre")
    private String nombre;
    private int ced;

    private String direccion;

    private int telefono1;

    private int telefono2;



    public AdultoResponsable() {
    }

    public AdultoResponsable(String nombre, int ced, String direccion, int telefono1, int telefono2) {
        this.nombre = nombre;
        this.ced = ced;
        this.direccion = direccion;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }



    // getters and setters


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

    public int getCed() {
        return ced;
    }

    public void setCed(int ced) {
        this.ced = ced;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(int telefono1) {
        this.telefono1 = telefono1;
    }

    public int getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(int telefono2) {
        this.telefono2 = telefono2;
    }


}
