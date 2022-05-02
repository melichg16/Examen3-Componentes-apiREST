package com.cenfotec.bibilotecaapi.repository;

import com.cenfotec.bibilotecaapi.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibro extends JpaRepository <Libro,Long> {
}
