package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.enums.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class KlassServiceTest {
    @Autowired
    private KlassService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateKlass() throws Exception {
        Klass klass = new Klass();
        klass.setName("Chemistry");
        klass.setDepartment(Department.ENGINEERING);
        klass.setFee(120);
        klass.setSemester(new Date());
        Klass after = this.service.create(klass);
        assertEquals(2,after.getId());
    }

    @Test
    public void shouldFindById() throws Exception {
        Klass klass = this.service.findById(1);
        assertEquals(1,klass.getId());

    }
    @Test
    public void shouldFindByName() throws Exception {
        Klass klass = this.service.findByName("Physics");
        assertEquals(1,klass.getId());
    }

    @Test
    public void shouldFindAllKlassesTaughtByTeacher() throws Exception{
        List<Klass> klasses = this.service.findAllKlassesByTeacherId(1);
        assertEquals(2,klasses.size());
    }
}