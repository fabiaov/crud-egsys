create table task (
                      id bigint not null auto_increment,
                      title varchar(250) not null,
                      description varchar(250) not null,
                      category_id bigint not null,
                      autor_id bigint not null,
                      data_creation datetime not null,
                      primary key (id),
                      foreign key (category_id) references category (id),
                      foreign key (autor_id) references user (id)
);