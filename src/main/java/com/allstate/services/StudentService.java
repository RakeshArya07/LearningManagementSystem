package com.allstate.services;

import com.allstate.entities.Student;
import com.allstate.repositories.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private IStudent studentRepository;

    @Autowired
    public void setStudentRepository(IStudent studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student std){
        return this.studentRepository.save(std);
    }

    public Student findById(int id){
        return this.studentRepository.findOne(id);
    }

    public Student findByEmail(String email){
        return  this.studentRepository.findByEmail(email);
    }
}
