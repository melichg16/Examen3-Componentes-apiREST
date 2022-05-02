package com.cenfotec.bibilotecaapi.service;

import com.cenfotec.bibilotecaapi.entities.AdultoResponsable;
import com.cenfotec.bibilotecaapi.repository.IAdultoResponsable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdultoResponsableImpl implements AdultoResponsableService {

    @Autowired
    IAdultoResponsable iAdultoResponsable;

    public AdultoResponsable save(AdultoResponsable adultoResponsable) {

        iAdultoResponsable.save(adultoResponsable);

        return adultoResponsable;
    }



}
