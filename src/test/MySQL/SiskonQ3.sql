-- Create database

CREATE DATABASE siskon;
USE siskon;

-- ############### Question 3 ###############

-- Create roles table

CREATE TABLE roles
(
RoleID INT,
RoleName VARCHAR(100)
);

-- Add roles data

INSERT INTO roles VALUES(1, 'Role A');
INSERT INTO roles VALUES(2, 'Role B');
INSERT INTO roles VALUES(3, 'Role C');
INSERT INTO roles VALUES(4, 'Role D');
INSERT INTO roles VALUES(5, 'Role E');

-- Read roles data

SELECT * FROM roles;

-- Create users table

CREATE TABLE users
(
UserID INT,
UserName VARCHAR(100)
);

-- Add users data

INSERT INTO users VALUES(1, 'User 1');
INSERT INTO users VALUES(2, 'User 2');
INSERT INTO users VALUES(3, 'User 3');
INSERT INTO users VALUES(4, 'User 4');
INSERT INTO users VALUES(5, 'User 5');

-- Read users data

SELECT * FROM users;

-- Create role_role_assignment table

CREATE TABLE role_role_assignment
(
ParentRoleID INT,
RoleID INT
);

-- Add role_role_assignment data

INSERT INTO role_role_assignment VALUES(1, 2);
INSERT INTO role_role_assignment VALUES(1, 3);
INSERT INTO role_role_assignment VALUES(2, 4);
INSERT INTO role_role_assignment VALUES(2, 5);

-- Read role_role_assignment data

SELECT * FROM role_role_assignment;

-- Create user_role_assignment table

CREATE TABLE user_role_assignment
(
UserID INT,
RoleID INT
);

-- Add user_role_assignment data

INSERT INTO user_role_assignment VALUES(1, 3);
INSERT INTO user_role_assignment VALUES(1, 4);
INSERT INTO user_role_assignment VALUES(2, 2);
INSERT INTO user_role_assignment VALUES(3, 2);
INSERT INTO user_role_assignment VALUES(4, 1);
INSERT INTO user_role_assignment VALUES(5, 2);

-- Read user_role_assignment data

SELECT * FROM user_role_assignment;

/* Task:
Create two table-valued function;
1- List assigned roles for provided user
2- List assigned users for provided role
*/

SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER //

CREATE PROCEDURE users_of_role (role_id INT)
	BEGIN
    SELECT UserID FROM user_role_assignment WHERE RoleID = role_id;
	END; //

DELIMITER ;

CALL users_of_role(2);

-- Todo: roles for provided user
-- Todo: Stored Procedure, while loop for sub roles

SELECT * FROM user_role_assignment WHERE UserID = 1; -- Single roles

SELECT RoleID FROM role_role_assignment WHERE ParentRoleID IN (SELECT RoleID FROM user_role_assignment WHERE UserID = 4); -- 1 level parent roles
