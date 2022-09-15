-- Create database

CREATE DATABASE siskon;
USE siskon;

-- ############### Question 2 ###############

-- Create student_course table

CREATE TABLE student_course
(
Student VARCHAR(100),
Course VARCHAR(100)
);

-- Add student_course data

INSERT INTO student_course VALUES('Student A','Course X');
INSERT INTO student_course VALUES('Student A','Course X');
INSERT INTO student_course VALUES('Student A','Course X');
INSERT INTO student_course VALUES('Student B','Course Y');
INSERT INTO student_course VALUES('Student B','Course Y');
INSERT INTO student_course VALUES('Student C','Course X');
INSERT INTO student_course VALUES('Student C','Course X');
INSERT INTO student_course VALUES('Student D','Course X');
INSERT INTO student_course VALUES('Student E','Course X');
INSERT INTO student_course VALUES('Student E','Course X');
INSERT INTO student_course VALUES('Student E','Course X');

-- Read student_course data

SELECT * FROM student_course;

-- Task: Modify the table to not contain duplicate records

CREATE TABLE student_course_temp SELECT DISTINCT Student, Course FROM student_course;
DROP TABLE student_course;
ALTER TABLE student_course_temp RENAME TO student_course;
SELECT * FROM student_course;