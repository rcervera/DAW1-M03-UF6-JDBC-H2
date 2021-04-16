DROP TABLE expedients;
DROP TABLE alumnes;
DROP TABLE assignatures;

CREATE TABLE assignatures(
   codi number(3) PRIMARY KEY,
   nom VARCHAR(50)
);

CREATE TABLE alumnes(
   dni VARCHAR(9) PRIMARY KEY,
   nom VARCHAR(30),
   adreça VARCHAR(50),
   telefon VARCHAR(10)
);

CREATE TABLE expedients(
  dni VARCHAR(9) REFERENCES alumnes,
  codi number(3) REFERENCES assignatures,
  nota_ordinaria number(4,2),
  nota_extraordinaria number(4,2),
  PRIMARY KEY(dni,codi)
 );

insert into alumnes values ('11111111A','Joan Gracia Moreno','Major 1, Tarragona','977111111');
insert into alumnes values ('22222222B','Maria Sants Garcia','Major 2, Tarragona','977222222');
insert into alumnes values ('33333333C','Sonia Soler Colina','Major 3, Tarragona','977333333');

insert into assignatures values(1,'Sistemes operatius');
insert into assignatures values(2,'Bases de dades');
insert into assignatures values(3,'Programació');

insert into expedients values('11111111A',1,7,null);
insert into expedients values('11111111A',2,9,null);
insert into expedients values('11111111A',3,4,8);

insert into expedients values('22222222B',1,4,6);
insert into expedients values('22222222B',2,5,null);
insert into expedients values('22222222B',3,7,null);

insert into expedients values('33333333C',1,10,null);
insert into expedients values('33333333C',2,6.8,null);
