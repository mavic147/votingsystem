DELETE FROM ROLES;
DELETE FROM USERS;
DELETE FROM USER_ROLES;
DELETE FROM RESTAURANTS;
DELETE FROM MENU;

INSERT INTO roles (id_role, name)
VALUES (100000, 'user'),
(100001, 'admin');

INSERT INTO users (id_user, name, email, password)
VALUES (100002, 'UserBob', 'bob@mail.ru', 'bob123'),
       (100003, 'UserAngelina', 'angelina@gmail.com', 'angelina555'),
       (100004, 'AdminSteve', 'steve@yahoo.com', 'steve321'),
       (100005, 'AdminCarmen', 'carmen@yandex.ru', 'carm567');

INSERT INTO USER_ROLES(id_user, id_role)
VALUES (100002, 100000),
       (100003, 100000),
       (100004, 100001),
       (100005, 100001);

INSERT INTO restaurants (id_restaurant, name)
VALUES (100006, 'Il Patio'),
       (100007, 'Doughnuts & Coffee');

INSERT INTO menu (id_menu, id_restaurant, name_dish, price_dish)
VALUES (100008, 100006, 'Ham & mushrooms pizza', 600),
       (100009, 100006, 'Pasta', 580),
       (100010, 100006, 'Apple Pie', 340),
       (100011, 100007, 'Cappuccino', 368),
       (100012, 100007, 'Doughnut with strawberry glaze', 150),
       (100013, 100007, 'Hot chocolate', 315),
       (100014, 100007, 'Doughnut with banana filling', 165);