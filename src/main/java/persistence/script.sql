drop database if exists blog;
create database blog;
use blog;

create table usuario(
	id int primary key auto_increment,
    nome varchar(50),
    sobrenome varchar(50),
    email varchar(50)unique,
    senha varchar(50),
    imagem varchar(500)
);

create table publicacao(
	id int primary key auto_increment,
	titulo varchar(50),
	texto varchar(500),
	imagem varchar(500),
    data timestamp,
    id_usuario int,
    constraint foreign key fk_usuario(id_usuario)references usuario(id)	
);

insert into usuario values(1,'renata','maciel','renatamaciel@gmail.com','123','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR188-3amf5gkfIVd8WB6ekWLKZDqfopBDs9yin7_hscOoXJf8C-g');
insert into usuario values(2,'antony','maciel','antonymaciel@gmail.com','123','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTfQME-0gq1QMybxoLPrYdhqYSIh-ss1FyvgJIdvUgjoMe-xG-mQ');
insert into usuario values(3,'rodrigo','vellozo','rv@gmail.com','123','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTa9XH8vN9wocntWr1ux7BLb1_38m_w0UzH9qIh0t9L_VByB77L');

select * from usuario;

insert into publicacao values(null, 'Bolsonaro X Renata Vasconcellos', 'Em sabatina no Jornal Nacional nesta terça-feira 28, o deputado federal e candidato à Presidência da República Jair Bolsonaro acabou virando o assunto mais comentado no Twitter. O motivo, no entanto, não foi algo que ele disse, mas sim um “deixa para lá” que a apresentadora Renata Vasconcellos deu no parlamentar.','https://abrilveja.files.wordpress.com/2018/08/design-sem-nome-3.png?quality=70&strip=info&resize=680,453', now(), 1);
insert into publicacao values(null,'Renata Vasconcellos rouba a cena dos presidenciáveis e ‘bomba’ na Internet','A rodada de entrevistas com os presidenciáveis no JN da Globo, pilotado pela dupla William Bonner e Renata Vasconcellos, não esclareceu muito das propostas e intenções dos candidatos. No entanto, revelou a habilidade da apresentadora Renata Vasconcellos em confrontar os candidatos, com respostas certeiras e incisivas.','https://www.esmaelmorais.com.br/wp-content/uploads/2018/08/renata-JN-587x330.jpg', now(), 1);

select * from publicacao;

select * from usuario u inner join publicacao p on u.id= p.id_usuario;















