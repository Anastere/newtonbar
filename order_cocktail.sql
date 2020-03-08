create table order_cocktail(
    order_id serial not null references orders(id),
    cocktail_id serial not null references cocktails(id),
    PRIMARY KEY (order_id, cocktail_id)
);