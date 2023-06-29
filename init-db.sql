create table category (
                          id bigserial primary key,
                          name varchar(250) not null
);

create table task (
                      id bigserial primary key,
                      title varchar(250) not null,
                      description varchar(250) not null,
                      category_id bigint not null references category(id),
                      data_creation timestamp not null
);

insert into category (id, name) values (1, 'Casa');
insert into category (id, name) values (2, 'Trabalho');
insert into category (id, name) values (3, 'Faculdade');

alter table task add column change_data date;
