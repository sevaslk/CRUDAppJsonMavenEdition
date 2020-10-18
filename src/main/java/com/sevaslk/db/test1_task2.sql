use test1;
CREATE TABLE IF NOT EXISTS Employee (Id int, Salary int);
TRUNCATE TABLE Employee;
INSERT INTO Employee (Id, Salary) values ('1', '100');
INSERT INTO Employee (Id, Salary) values ('2', '200');
INSERT INTO Employee (Id, Salary) values ('3', '300');
SELECT * FROM Employee 
WHERE Salary < (SELECT MAX(Salary) FROM Employee)
ORDER BY Salary DESC LIMIT 1;