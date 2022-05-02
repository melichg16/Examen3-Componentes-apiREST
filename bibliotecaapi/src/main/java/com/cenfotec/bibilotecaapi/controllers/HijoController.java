package com.cenfotec.bibilotecaapi.controllers;

import com.cenfotec.bibilotecaapi.entities.AdultoResponsable;
import com.cenfotec.bibilotecaapi.entities.Hijo;
import com.cenfotec.bibilotecaapi.repository.IAdultoResponsable;
import com.cenfotec.bibilotecaapi.repository.IHijo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hijos")
public class HijoController {


    @Autowired
        IHijo iHijo;
    @Autowired
    IAdultoResponsable iAdultoResponsable;



  /*  public HijoController(IHijo iHijo, IAdultoResponsable iAdultoResponsable) {
        this.iHijo = iHijo;
        this.iAdultoResponsable = iAdultoResponsable;
    }*/
    //registrar adultoR

    @PostMapping
    public Object create(@RequestBody Hijo hijo){


        return  iHijo.save(hijo);
    }



    //listar hijos
    @GetMapping
    public List findAll() {
        return iHijo.findAll();
    }

    //update datos adultoR
    @PutMapping(path = { "/{id}" })
    public ResponseEntity<Hijo> update(@PathVariable("id") long id, @RequestBody Hijo hijo) {
        return iHijo.findById(id).map(record -> {
            record.setNombre(hijo.getNombre());
            record.setTipoPlan(hijo.getTipoPlan());
            record.setAlergias(hijo.getAlergias());

            Hijo updated = iHijo.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }




}
