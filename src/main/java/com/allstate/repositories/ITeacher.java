package com.allstate.repositories;


import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITeacher extends CrudRepository<Teacher,Integer>{

    public Teacher findByName(String name);
    public List<Teacher> findByGender(Gender gender);
    public List<Teacher> findByAgeGreaterThan(int id);

}
