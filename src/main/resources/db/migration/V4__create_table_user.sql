create table users (
                        id bigint not null auto_increment,
                        nome varchar(50) not null,
                        email varchar(50) not null,
                        password varchar(100) not null,
                        primary key(id)
);

insert into users values(1, 'Marcos da Silva', 'marcos@email.com');