drop schema coderslab;
create schema coderslab;

CREATE TABLE coderslab.USERS_GROUPS (
	ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME varchar(255)
);

CREATE TABLE coderslab.USERS (
    ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    USER_GROUP_ID int,
    USERNAME varchar(255) NOT NULL,
    PASSWORD varchar(255) NOT NULL,
    EMAIL varchar(255),
    
    FOREIGN KEY (USER_GROUP_ID) REFERENCES USERS_GROUPS(ID)
);

CREATE TABLE coderslab.EXERCISES (
	ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TITLE varchar(255),
    DESCRIPTION varchar(255)
);

CREATE TABLE coderslab.SOLUTIONS (
	ID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    EXERCISE_ID int,
    USER_ID int,
    UPDATED_AT DATETIME,
    CREATED_AT DATETIME,
    DESCRIPTION varchar(255),
    
    FOREIGN KEY (EXERCISE_ID) REFERENCES EXERCISES(ID),
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);


-------------------- TEST DATA ----------------------
-------------------- USERS GROUPS ----------------------
insert into coderslab.USERS_GROUPS(NAME) VALUES ('Grupa A');
insert into coderslab.USERS_GROUPS(NAME) VALUES ('Grupa B');

-------------------- USERS ----------------------
insert into coderslab.USERS(USER_GROUP_ID, USERNAME, PASSWORD, EMAIL) VALUES (1, 'lukaszs7', 'abc123', 'lukasz.szmolke@gmail.com');
insert into coderslab.USERS(USER_GROUP_ID, USERNAME, PASSWORD, EMAIL) VALUES (2, 'darek123', 'abc123', 'darek123@gmail.com');
insert into coderslab.USERS(USER_GROUP_ID, USERNAME, PASSWORD, EMAIL) VALUES (1, 'tomek123', 'abc123', 'tomek123@gmail.com');
insert into coderslab.USERS(USER_GROUP_ID, USERNAME, PASSWORD, EMAIL) VALUES (1, 'klaudia123', 'abc123', 'klaudia123@gmail.com');

-------------------- EXERCISES ----------------------
insert into coderslab.EXERCISES(TITLE, DESCRIPTION) VALUES ('Coderslab Warsztat JSP', 'Cwiczymy JSP');
insert into coderslab.EXERCISES(TITLE, DESCRIPTION) VALUES ('Coderslab SQL', 'Cwiczymy SQL');

-------------------- SOLUTIONS ----------------------
insert into coderslab.SOLUTIONS(EXERCISE_ID, USER_ID, UPDATED_AT, CREATED_AT, DESCRIPTION) VALUES (1, 1, null, '2020-01-01 10:10:10', 'Opis oddania cwiczenia z JSP');
insert into coderslab.SOLUTIONS(EXERCISE_ID, USER_ID, UPDATED_AT, CREATED_AT, DESCRIPTION) VALUES (1, 1, null, '2020-01-02 12:12:11', 'Opis oddania cwiczenia z JSP');
insert into coderslab.SOLUTIONS(EXERCISE_ID, USER_ID, UPDATED_AT, CREATED_AT, DESCRIPTION) VALUES (2, 1, null, '2020-01-03 10:10:10', 'Opis oddania cwiczenia z SQL');
insert into coderslab.SOLUTIONS(EXERCISE_ID, USER_ID, UPDATED_AT, CREATED_AT, DESCRIPTION) VALUES (1, 2, null, '2020-01-04 10:10:10', 'Opis oddania cwiczenia z JSP');
insert into coderslab.SOLUTIONS(EXERCISE_ID, USER_ID, UPDATED_AT, CREATED_AT, DESCRIPTION) VALUES (2, 2, null, '2020-01-05 10:10:10', 'Opis oddania cwiczenia z SQL');
insert into coderslab.SOLUTIONS(EXERCISE_ID, USER_ID, UPDATED_AT, CREATED_AT, DESCRIPTION) VALUES (1, 3, null, '2020-01-06 10:10:10', 'Opis oddania cwiczenia z JSP');
insert into coderslab.SOLUTIONS(EXERCISE_ID, USER_ID, UPDATED_AT, CREATED_AT, DESCRIPTION) VALUES (1, 4, null, '2020-01-07 10:10:10', 'Opis oddania cwiczenia z JSP');
insert into coderslab.SOLUTIONS(EXERCISE_ID, USER_ID, UPDATED_AT, CREATED_AT, DESCRIPTION) VALUES (2, 4, null, '2020-01-08 10:10:10', 'Opis oddania cwiczenia z SQL');