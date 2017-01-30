package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {

    @Autowired
    private TeacherService service;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateStudent() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setName("Nathan");
        teacher.setGender(Gender.MALE);
        teacher.setAge(27);
        Teacher after = this.service.create(teacher);
        assertEquals(3,after.getId());
        assertEquals("Nathan",after.getName());
    }

    @Test
    public void shouldFindById() throws Exception {
        Teacher teacher = this.service.findById(2);
        assertEquals(2,teacher.getId());
        assertEquals("Andeas",teacher.getName());
    }

    @Test
    public void shouldFindByGender() throws Exception {
        List<Teacher> teachers = this.service.findByGender("MALE");
        assertEquals(2,teachers.size());
    }

    @Test
    public void shouldFindByAge() throws Exception {
        List<Teacher> teachers = this.service.findByAgeGreaterThan(30);
        assertEquals(2,teachers.size());
    }

    @Test
    public void shouldFindListOfClassesToughtByteacher() throws Exception {
        List<Klass> klasses = this.service.findClassesToughtByTeacher("Chyld");
        assertEquals(1,klasses.size());
    }
}