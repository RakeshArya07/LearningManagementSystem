package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    public void shouldCreateStudent() throws Exception {
        Student student = new Student();
        student.setEmail("test@gmail.com");
		Student after = this.service.create(student);
		assertEquals(3,after.getId());
    }

    @Test
    public void shouldFindById() throws Exception {
       Student student = this.service.findById(1);
       assertEquals(1,student.getId());
       assertEquals("rk@gmail.com",student.getEmail());
    }

    @Test
    public void shouldFindByEmail() throws Exception {
        Student student = this.service.findByEmail("test@gmail.com");
        assertEquals(2,student.getId());
        assertEquals("test@gmail.com",student.getEmail());
    }

}