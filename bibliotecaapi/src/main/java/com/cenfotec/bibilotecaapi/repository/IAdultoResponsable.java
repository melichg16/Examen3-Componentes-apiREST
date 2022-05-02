package com.cenfotec.bibilotecaapi.repository;

import com.cenfotec.bibilotecaapi.entities.AdultoResponsable;
import com.cenfotec.bibilotecaapi.entities.Hijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAdultoResponsable extends JpaRepository <AdultoResponsable,Long>{



    @Query(value = "SELECT * FROM adultosR a WHERE a.nombre LIKE %?1%", nativeQuery = true)
    List<AdultoResponsable> findByNombreLike(String nombre);

    @Query(value = "SELECT * FROM Hijos h WHERE h.idAulto = 1", nativeQuery = true)
    Hijo findByAdulto (long id);



    AdultoResponsable findById(String id);
}
