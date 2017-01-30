package com.allstate.services;


import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.repositories.IKlass;
import com.allstate.repositories.ITeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private ITeacher teacherRepository;
    private IKlass klassRepository;

    @Autowired
    public void setStudentRepository(ITeacher teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Autowired
    public void setKlassRepository(IKlass klassRepository) {this.klassRepository = klassRepository;}

    public Teacher create(Teacher teacher){
        return this.teacherRepository.save(teacher);
    }

    public Teacher findById(int id){
        return this.teacherRepository.findOne(id);
    }

    public List<Teacher> findByGender(String gender){
        return this.teacherRepository.findByGender(gender);
    }


    public List<Teacher> findByAgeGreaterThan(int age){
        return this.teacherRepository.findByAgeGreaterThan(age);
    }

}
