package com.allstate.repositories;


import com.allstate.entities.Klass;
import org.springframework.data.repository.CrudRepository;

public interface IKlass extends CrudRepository<Klass,Integer>{
    public Klass findByName(String name);
}
