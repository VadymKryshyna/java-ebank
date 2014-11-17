INSERT INTO Persons(name, address) VALUES ('Petrov Petr','Kiev');
INSERT INTO Persons(name, address) VALUES ('Ivanov Ivan','Lvov');
INSERT INTO Persons(name, address) VALUES ('Sidorov Sidr','Odessa');
INSERT INTO Persons(name, address) VALUES ('Barak Obama','Vinitsa');

INSERT INTO Accounts(id_person, balance, title) VALUES (1, 100, 'debit');
INSERT INTO Accounts(id_person, balance, title) VALUES (1, 50, 'credit');
INSERT INTO Accounts(id_person, balance, title) VALUES (2, 200, 'debit');
INSERT INTO Accounts(id_person, balance, title) VALUES (2, 300, 'credit');
INSERT INTO Accounts(id_person, balance, title) VALUES (3, 800, 'debit');
INSERT INTO Accounts(id_person, balance, title) VALUES (3, 400, 'credit');

INSERT INTO Transactions (idAccountDebit, idAccountCredit, sumTransaction) VALUES (1,2,20);
INSERT INTO Transactions (idAccountDebit, idAccountCredit, sumTransaction) VALUES (2,3,30);
INSERT INTO Transactions (idAccountDebit, idAccountCredit, sumTransaction) VALUES (3,4,50);
INSERT INTO Transactions (idAccountDebit, idAccountCredit, sumTransaction) VALUES (4,1,10);
INSERT INTO Transactions (idAccountDebit, idAccountCredit, sumTransaction) VALUES (3,1,40);
INSERT INTO Transactions (idAccountDebit, idAccountCredit, sumTransaction) VALUES (4,2,30);
