package com.cenfotec.bibilotecaapi.controllers;

import com.cenfotec.bibilotecaapi.entities.AdultoResponsable;
import com.cenfotec.bibilotecaapi.entities.Hijo;
import com.cenfotec.bibilotecaapi.repository.IAdultoResponsable;
import com.cenfotec.bibilotecaapi.repository.IHijo;
import com.cenfotec.bibilotecaapi.service.AdultoResponsableImpl;
import com.sun.deploy.net.MessageHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping({ "/adultosR" })

public class AdultoResposableController {

  @Autowired
    AdultoResponsableImpl adultoResponsableImpl;
    @Autowired
    IAdultoResponsable iAdultoResponsable;
    @Autowired
    IHijo iHijo;

   public AdultoResposableController(AdultoResponsableImpl adultoResponsableImpl, IAdultoResponsable iAdultoResponsable) {
        this.adultoResponsableImpl = adultoResponsableImpl;
        this.iAdultoResponsable = iAdultoResponsable;
    }

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }
    //registrar adultoR

    @PostMapping
    public AdultoResponsable create(@RequestBody AdultoResponsable adultoResponsable) {
        return iAdultoResponsable.save(adultoResponsable);
    }

    @GetMapping(path= "/buscarPorId/{id}")
    public Object findById(@PathVariable("id") Long id) {
        Optional<AdultoResponsable> posibleResult = iAdultoResponsable.findById(id);
        if (posibleResult.isPresent()) {
            AdultoResponsable result = posibleResult.get();

            return result;
        }
        return ResponseEntity.notFound().build()  ;
    }

    //listar adultosR
    @GetMapping
    public List findAll() {
        return iAdultoResponsable.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public ArrayList<Object> familias (@PathVariable("id") long id){
        ArrayList<Object> resultados = new ArrayList<Object>();
       Optional<AdultoResponsable> adulto = iAdultoResponsable.findById(id);
        List<Hijo> hijos = iHijo.findAll();
        for (int i=0; i< hijos.size();i++){
            if(hijos.get(i).getIdAdulto()== id){

                resultados.add(hijos.get(i));
            }
        }

       resultados.add(adulto.get());


       return resultados ;
    }

    //update datos adultoR
    @PutMapping(path = { "/{id}" })
    public ResponseEntity<AdultoResponsable> update(@PathVariable("id") long id, @RequestBody AdultoResponsable adultoResponsable) {
        return iAdultoResponsable.findById(id).map(record -> {
            record.setNombre(adultoResponsable.getNombre());
            record.setCed(adultoResponsable.getCed());
            record.setDireccion(adultoResponsable.getDireccion());
            record.setTelefono1(adultoResponsable.getTelefono1());
            record.setTelefono2(adultoResponsable.getTelefono2());


           AdultoResponsable updated = iAdultoResponsable.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    //buscar el padre o la madre por aproximacion del nombre y/o apellido

   @GetMapping (path={"/filtrar/{nombre}"})
    public List findByApproximation(@PathVariable("nombre")String nombre) {

      List<AdultoResponsable> found = iAdultoResponsable.findByNombreLike(nombre);

       if(found.size()<1){
           return (List) ResponseEntity.notFound().build();
       }


        return found;
    }





 }

