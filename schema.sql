create table recipes
(
    recipe_name varchar(50)   not null
        primary key,
    batter      varchar(50)   null,
    frosting    varchar(50)   null,
    topping     varchar(50)   null,
    prep_time   int           null,
    cost        decimal(6, 2) null,
    recipe_id   int           null
);

create table orders
(
    cake_name         varchar(50)   null,
    creation_date     date          null,
    delivery_date     date          null,
    delivery_location varchar(50)   null,
    message           varchar(50)   null,
    final_cost        decimal(6, 2) null,
    constraint cake_name__fk
        foreign key (cake_name) references recipes (recipe_name)
);


