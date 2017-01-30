package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.repositories.IKlass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlassService {
    private IKlass repository;

    @Autowired
    public void setRepository(IKlass repository) {
        this.repository = repository;
    }

    public Klass create(Klass klass){
        return this.repository.save(klass);
    }

    public Klass findById(int id){
        return this.repository.findOne(id);
    }

    public Klass findByName(String name){ return this.repository.findByName(name);}

    public List<Klass> findAllKlassesByTeacherId(int id){
        return this.repository.findAllKlassesByTeacherId(id);
    }

}
