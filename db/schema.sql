create table mark (
    id serial primary key,
    name text
);

create table body (
    id serial primary key,
    name text
);

create table car (
    id serial primary key,
    name text,
    mark_id int references mark(id),
    body_id int references body(id)
);

create table photo (
    id serial primary key,
    path text,
    ad_id int references ad(id)
);

create table users (
    id serial primary key,
    login text,
    password text,
);

create table ad (
    id serial primary key,
    description text,
    actual boolean,
    car_id int references  car(id),
    user_id int references users(id)
);