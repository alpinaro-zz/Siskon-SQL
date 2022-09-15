-- Create database

CREATE DATABASE siskon;
USE siskon;

-- ############### Question 1 ###############

-- Create course table

CREATE TABLE course
(
CourseID VARCHAR(4)
);

-- Add course data

INSERT INTO course VALUES('SOS1');
INSERT INTO course VALUES('MAT3');
INSERT INTO course VALUES('FEN2');

-- Read course data

SELECT * FROM course;

-- Create course_student table

CREATE TABLE course_student
(
CourseID VARCHAR(4),
Student VARCHAR(50)
);

-- Add course_student data

INSERT INTO course_student VALUES('MAT3', 'Mehmet');
INSERT INTO course_student VALUES('SOS1', 'Ahmet');
INSERT INTO course_student VALUES('MAT3', 'Ahmet');
INSERT INTO course_student VALUES('FEN2', 'Ahmet');
INSERT INTO course_student VALUES('SOS1', 'Ali');
INSERT INTO course_student VALUES('FEN2', 'Ayse');

-- Read course_student data

SELECT * FROM course_student;

-- Task: List students that takes all available courses

SELECT DISTINCT cs1.Student FROM course_student cs1 WHERE NOT EXISTS (SELECT 'x' FROM course c WHERE NOT EXISTS (SELECT 'x' FROM course_student cs2 WHERE c.CourseID = cS2.CourseID AND cs1.Student = cs2.Student));