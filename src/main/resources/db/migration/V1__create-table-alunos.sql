create table alunos(
	id bigint auto_increment not null,
	nome varchar(100)  not null,
	cpf varchar(100) not null unique,
	email varchar(100) not null unique,
	telefone varchar(100)  not null,
	datanascimento DATE not null,
	sexo varchar(15) not null,
	datamatricula DATE not null,
	primary key(id)
	
);