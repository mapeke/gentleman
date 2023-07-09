INSERT INTO t_permission (role)
VALUES
    ('ROLE_USER'),
    ('ROLE_BARBER'),
    ('ROLE_ADMIN');

INSERT INTO t_users (email, full_name, password)
VALUES
    ('adil@gmail.com', 'Adil Mukhametbek', '$2a$10$AEy/qVLBR1IEBqXzv4BmkemJCHCi1GDdVzlzEKrrEk.SM7dsuXE72'),
    ('ilyas@gmail.com', 'Ilyas Zhuanyshev', '$2a$10$AEy/qVLBR1IEBqXzv4BmkemJCHCi1GDdVzlzEKrrEk.SM7dsuXE72'),
    ('amir@gmail.com', 'Amir Abutalipov', '$2a$10$AEy/qVLBR1IEBqXzv4BmkemJCHCi1GDdVzlzEKrrEk.SM7dsuXE72'),
    ('lev@gmail.com', 'Lev Kupich', '$2a$10$AEy/qVLBR1IEBqXzv4BmkemJCHCi1GDdVzlzEKrrEk.SM7dsuXE72'),
    ('misha@gmail.com', 'Michael Mihin', '$2a$10$AEy/qVLBR1IEBqXzv4BmkemJCHCi1GDdVzlzEKrrEk.SM7dsuXE72'),
    ('vadim@gmail.com', 'Vadim Safronov', '$2a$10$AEy/qVLBR1IEBqXzv4BmkemJCHCi1GDdVzlzEKrrEk.SM7dsuXE72');

INSERT INTO t_users_permissions (user_id, permissions_id)
VALUES
    (1,1), (1,2), (1,3),
    (2,1), (2,2),
    (3,1), (3,2),
    (4,1),
    (5,1),
    (6,1);

INSERT INTO t_orders (barber_id, client_id, date, approved)
VALUES
    (1, 3, '2023-07-07T15:30:00', true),
    (1, 6, '2023-07-07T14:30:00', false),
    (1, 4, '2023-07-07T16:00:00', false),
    (2, 5, '2023-07-07T18:00:00', false),
    (1, 5, '2023-07-27T15:30:00', false),
    (1, 3, '2023-07-27T15:30:00', false),
    (2, 6, '2023-07-27T15:30:00', false),
    (2, 4, '2023-07-27T15:30:00', true),
    (2, 5, '2023-08-07T15:30:00', false),
    (2, 4, '2023-08-07T15:30:00', false),
    (1, 3, '2023-08-07T15:30:00', false);