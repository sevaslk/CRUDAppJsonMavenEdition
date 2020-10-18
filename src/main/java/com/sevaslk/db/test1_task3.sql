use test1;
CREATE TABLE IF NOT EXISTS Employee_task3 (Id int, Name varchar(255), Salary int, ManagerId int);
TRUNCATE TABLE Employee_task3;
INSERT INTO Employee_task3 (Id, Name, Salary, ManagerId) values ('1', 'Joe', '70000', '3');
INSERT INTO Employee_task3 (Id, Name, Salary, ManagerId) values ('2', 'Henry', '80000', '4');
INSERT INTO Employee_task3 (Id, Name, Salary, ManagerId) values ('3', 'Sam', '60000', null);
INSERT INTO Employee_task3 (Id, Name, Salary, ManagerId) values ('4', 'Max', '90000', null);
SELECT employee.Name FROM Employee_task3 AS employee JOIN Employee_task3 AS manager ON manager.Id = employee.ManagerId
WHERE employee.Salary > manager.Salary;