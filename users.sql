create table users (
      id serial primary key,
      name varchar(255) not null,
      lastname varchar(255) not null,
      password varchar(255) not null
);