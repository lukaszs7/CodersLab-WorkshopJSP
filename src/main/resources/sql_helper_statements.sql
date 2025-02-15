SELECT * FROM coderslab.USERS;

SELECT * FROM coderslab.SOLUTIONS 
JOIN coderslab.USERS_GROUPS
JOIN coderslab.USERS
JOIN coderslab.EXERCISES;

SELECT * FROM coderslab.USERS JOIN coderslab.USERS_GROUPS;

SELECT * FROM coderslab.SOLUTIONS
JOIN coderslab.USERS
JOIN coderslab.EXERCISES
ORDER BY CREATED_AT 
LIMIT 5;

# delete records

SET FOREIGN_KEY_CHECKS = 0; 
TRUNCATE TABLE coderslab.EXERCISES;
TRUNCATE TABLE coderslab.USERS_GROUPS;
TRUNCATE TABLE coderslab.USERS;
TRUNCATE TABLE coderslab.SOLUTIONS;
SET FOREIGN_KEY_CHECKS = 1;