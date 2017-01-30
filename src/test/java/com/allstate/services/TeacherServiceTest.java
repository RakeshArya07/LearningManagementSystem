package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Department;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {

    @Autowired
    private TeacherService service;

    @Autowired
    private KlassService klassService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateTeacher() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setName("Nathan");
        teacher.setGender(Gender.MALE);
        teacher.setAge(27);
        Teacher after = this.service.create(teacher);
        assertEquals(3,after.getId());
        assertEquals("Nathan",after.getName());
        assertEquals(Gender.MALE,after.getGender());
    }

    @Test
    public void shouldFindById() throws Exception {
        Teacher teacher = this.service.findById(2);
        assertEquals(2,teacher.getId());
        assertEquals("Andeas",teacher.getName());
    }

    @Test
    public void shouldFindTeacherByName() throws Exception{
        Teacher teacher = this.service.findByName("Chyld");
        assertEquals(1,teacher.getId());
    }

    @Test
    public void shouldFindByGender() throws Exception {
        List<Teacher> teachers = this.service.findByGender(Gender.MALE);
        assertEquals(2,teachers.size());
    }

    @Test
    public void shouldNotFindByGenderFemale() throws Exception {
        List<Teacher> teachers = this.service.findByGender(Gender.FEMALE);
        assertEquals(0,teachers.size());
    }

    @Test
    public void shouldFindByAge() throws Exception {
        List<Teacher> teachers = this.service.findByAgeGreaterThan(30);
        assertEquals(2,teachers.size());
    }
    @Test
    @Transactional
    public void shouldFindAllKlassesTaughtByTeacher() throws Exception{
        Klass klass = new Klass();
        klass.setName("Chemistry");
        klass.setDepartment(Department.ENGINEERING);
        klass.setFee(120);
        klass.setSemester(new Date());
        klass.setTeacher(this.service.findById(1));
        this.klassService.create(klass);
        List<Klass> klasses = this.service.findAllKlassesByTeacher(1);
        assertEquals(3,klasses.size());
    }


}