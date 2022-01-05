CREATE TABLE pet(
	id serial primary key,
	nome varchar(50) not null,
	tipo varchar(20) not null
);

insert into pet (nome, tipo) values ('Popo','CACHORRO');
insert into pet (nome, tipo) values ('Milk','GATO');
insert into pet (nome, tipo) values ('Anakin','GATO');