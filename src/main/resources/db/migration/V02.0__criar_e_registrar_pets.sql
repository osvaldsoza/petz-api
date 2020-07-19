CREATE TABLE pet(
	id serial primary key,
	nome varchar(50) not null,
	tipo varchar(20) not null,
	cliente_id bigint not null,
	FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

insert into pet (nome, tipo,cliente_id) values ('Popo','CACHORRO',1);
insert into pet (nome, tipo,cliente_id) values ('Milk','GATO',1);
insert into pet (nome, tipo,cliente_id) values ('Anakin','GATO',2);