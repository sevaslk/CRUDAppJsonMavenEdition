use test1;
CREATE TABLE IF NOT EXISTS PersonWithEmail (Id int, Email varchar(255));
TRUNCATE TABLE PersonWithEmail;
INSERT INTO PersonWithEmail (Id, Email) values ('1', 'a@b.com');
INSERT INTO PersonWithEmail (Id, Email) values ('2', 'c@d.com');
INSERT INTO PersonWithEmail (Id, Email) values ('3', 'a@b.com');
SELECT Email FROM PersonWithEmail GROUP BY Email HAVING COUNT(Email)>1;