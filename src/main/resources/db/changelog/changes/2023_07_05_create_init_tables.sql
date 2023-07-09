CREATE TABLE t_users (
    id bigint auto_increment,
    email varchar(255),
    password varchar(255),
    full_name varchar(255),
    primary key (id)
);

CREATE TABLE t_permission (
    id bigint auto_increment,
    role varchar(255),
    primary key (id)
);

CREATE TABLE t_orders (
    id bigint auto_increment,
    client_id bigint,
    barber_id bigint,
    date datetime,
    approved boolean default false,
    primary key (id),
    foreign key (client_id) references t_users(id),
    foreign key (barber_id) references t_users(id)
);

CREATE TABLE t_users_permissions (
    user_id bigint,
    permissions_id bigint,
    primary key (user_id, permissions_id),
    foreign key (user_id) references t_users(id),
    foreign key (permissions_id) references t_permission(id)
    on delete cascade
);
