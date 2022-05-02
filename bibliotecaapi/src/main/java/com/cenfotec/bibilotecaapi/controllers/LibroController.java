package com.cenfotec.bibilotecaapi.controllers;

import com.cenfotec.bibilotecaapi.entities.Hijo;
import com.cenfotec.bibilotecaapi.entities.Libro;
import com.cenfotec.bibilotecaapi.repository.IHijo;
import com.cenfotec.bibilotecaapi.repository.ILibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    ILibro iLibro;

    @Autowired
    IHijo iHijo;

    @PostMapping
    public Libro create(@RequestBody Libro libro){


        return  iLibro.save(libro);
    }
    @GetMapping
    public List findAll() {
        return iLibro.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public Optional<Libro> findById(@PathVariable("id") long id) {
        return iLibro.findById(id);
    }

    @GetMapping(path = { "/librosLeidos/{id}" })
    public ArrayList<Optional>  librosLeidos (@PathVariable("id") long id){
        Optional<Hijo> hijo = iHijo.findById(id);
        ArrayList<Optional> resultados = new ArrayList<Optional>();
        ArrayList<Long> libros = hijo.get().getLibroList();

        for (int i=0; i< libros.size();i++){

            Optional<Libro>  libro = iLibro.findById(libros.get(i));
            resultados.add(libro);


        }
        return resultados;

    }

    @GetMapping(path = { "/cantLibros/{id}" })
    public String getCantLibros (@PathVariable("id") long id){
        ArrayList<Object> resultados = new ArrayList<Object>();
        Optional<Hijo> hijo = iHijo.findById(id);
        ArrayList<Long> libros = hijo.get().getLibroList();
        int cantLibros = libros.size();
        return hijo.get().getNombre() + "ha leído " + cantLibros + " libros";
    }



}
