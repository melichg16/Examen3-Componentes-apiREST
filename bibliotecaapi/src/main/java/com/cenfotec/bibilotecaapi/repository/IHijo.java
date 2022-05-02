package com.cenfotec.bibilotecaapi.repository;

import com.cenfotec.bibilotecaapi.entities.Hijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHijo extends JpaRepository <Hijo,Long>{

}
