create table cocktails
(
  id     serial primary key,
  name   varchar(255) not null unique,
  price  money        not null,
  recipe json         not null
);