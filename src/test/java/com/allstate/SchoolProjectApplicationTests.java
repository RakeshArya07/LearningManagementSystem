package com.allstate;

import com.allstate.entities.Student;
import com.allstate.services.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({
        StudentServiceTest.class,
        KlassServiceTest.class,
        TeacherServiceTest.class
})
public class SchoolProjectApplicationTests {

}
