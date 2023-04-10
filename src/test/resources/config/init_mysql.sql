CREATE TABLE employees
(
    id   INT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    PRIMARY KEY (id)
);

insert into employees values (1, 'Bilbo Baggins', 'burglar');
insert into employees values (2, 'Frodo Baggins', 'thief');