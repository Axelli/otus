create table if not exists tab_user
(
    id         serial primary key,
    username   varchar(100) not null,
    first_name varchar(100),
    last_name  varchar(100),
    email      varchar(100),
    phone      varchar(40)
);

create table if not exists tab_user (id serial primary key, username varchar(100) not null, first_name varchar(100), last_name varchar(100), email varchar(100), phone varchar(40));

