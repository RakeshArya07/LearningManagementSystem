package com.allstate.repositories;


import com.allstate.entities.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITeacher extends CrudRepository<Teacher,Integer>{

    String sql1 = "select *  from teachers where gender = :gender";
    @Query(value = sql1, nativeQuery = true)
    public List<Teacher> findByGender(@Param("gender") String gender);

    String sql2 = "select *  from teachers where age > :age";
    @Query(value = sql2, nativeQuery = true)
    public List<Teacher> findByAgeGreaterThan (@Param("age") int age);



}
