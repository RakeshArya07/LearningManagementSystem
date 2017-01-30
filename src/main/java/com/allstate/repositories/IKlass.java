package com.allstate.repositories;


import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IKlass extends CrudRepository<Klass,Integer>{
    public Klass findByName(String name);

    String sql1= "select *  from klasses where teacher_id > :id";
    @Query(value = sql1, nativeQuery = true)
    public List<Klass> findAllKlassesByTeacherId (@Param("id") int id);
}
