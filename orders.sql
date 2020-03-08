create table orders
(
    id serial primary key,
    user_id int not null references users(id),
    quantity int not null,
    total_price money not null
);