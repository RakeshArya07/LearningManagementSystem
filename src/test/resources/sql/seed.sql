use schooltest;

set FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE students;
TRUNCATE TABLE klasses;
TRUNCATE TABLE teachers;

set FOREIGN_KEY_CHECKS = 1;
INSERT into students (id,version,email) values (1,0,'rk@gmail.com');
INSERT into students (id,version,email) values (2,0,'test@gmail.com');
INSERT into teachers (id,name,gender,age) values (1,'Chyld','MALE',35),(2,'Andeas','MALE',32);


INSERT into klasses (id,name,semester,department,fee,teacher_id) values
                    (1,'Physics','2015-03-11 00:00:00.000','ENGINEERING',100.00,1),
                    (2,'Chemistry','2015-03-11 00:00:00.000','ENGINEERING',150.00,1);


