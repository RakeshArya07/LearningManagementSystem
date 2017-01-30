use schooltest;

TRUNCATE TABLE students;

INSERT into students (id,version,email) values (1,0,'rk@gmail.com');
INSERT into students (id,version,email) values (2,0,'test@gmail.com');

TRUNCATE TABLE klasses;
INSERT into klasses (id,name,semester,department,fee) values (1,'Physics','2015-03-11 00:00:00.000','ENGINEERING',100.00);




