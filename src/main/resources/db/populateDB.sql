DELETE FROM USER_ROLES where 1=1;
DELETE FROM ROLES where 1=1 ;
DELETE FROM USERS where 1=1;
DELETE FROM RESTAURANTS where 1=1;
DELETE FROM DISHES where 1=1;
DELETE FROM MENU where 1=1;
DELETE FROM RATING where 1=1;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100000;

INSERT INTO roles (id, name)
VALUES (NEXT VALUE FOR GLOBAL_SEQ, 'user'),
       (NEXT VALUE FOR GLOBAL_SEQ, 'admin');

INSERT INTO users (id, name, email, password)
VALUES (NEXT VALUE FOR GLOBAL_SEQ, 'UserBob', 'bob@mail.ru', 'bob123'),
       (NEXT VALUE FOR GLOBAL_SEQ, 'UserAngelina', 'angelina@gmail.com', 'angelina555'),
       (NEXT VALUE FOR GLOBAL_SEQ, 'AdminSteve', 'steve@yahoo.com', 'steve321'),
       (NEXT VALUE FOR GLOBAL_SEQ, 'AdminCarmen', 'carmen@yandex.ru', 'carm567');

INSERT INTO USER_ROLES(id_user, id_role)
VALUES ((select id from USERS where name = 'UserBob'), (select id from ROLES where name = 'user')),
       ((select id from USERS where name = 'UserAngelina'), (select id from ROLES where name = 'user')),
       ((select id from USERS where name = 'AdminSteve'), (select id from ROLES where name = 'admin')),
       ((select id from USERS where name = 'AdminCarmen'), (select id from ROLES where name = 'admin'));

INSERT INTO restaurants (id, name)
VALUES (NEXT VALUE FOR GLOBAL_SEQ, 'Il Patio'),
       (NEXT VALUE FOR GLOBAL_SEQ, 'Doughnuts & Coffee');

INSERT INTO dishes (id, name, deleted)
VALUES (NEXT VALUE FOR GLOBAL_SEQ, 'Ham & mushrooms pizza', false),
       (NEXT VALUE FOR GLOBAL_SEQ, 'Pasta', false),
       (NEXT VALUE FOR GLOBAL_SEQ, 'Apple Pie', false),
       (NEXT VALUE FOR GLOBAL_SEQ, 'Cappuccino', false),
       (NEXT VALUE FOR GLOBAL_SEQ, 'Doughnut with strawberry glaze', false),
       (NEXT VALUE FOR GLOBAL_SEQ, 'Hot chocolate', false),
       (NEXT VALUE FOR GLOBAL_SEQ, 'Doughnut with banana filling', false);

INSERT INTO menu (id, id_restaurant, id_dish, price_dish)
VALUES (NEXT VALUE FOR GLOBAL_SEQ, (select id from RESTAURANTS where NAME = 'Il Patio'), (Select id from dishes where name = 'Ham & mushrooms pizza'), 600),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from RESTAURANTS where NAME = 'Il Patio'), (Select id from dishes where name = 'Pasta'), 580),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from RESTAURANTS where NAME = 'Il Patio'), (Select id from dishes where name = 'Apple Pie'), 340),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from RESTAURANTS where NAME = 'Doughnuts & Coffee'), (Select id from dishes where name = 'Cappuccino'), 368),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from RESTAURANTS where NAME = 'Doughnuts & Coffee'), (Select id from dishes where name ='Doughnut with strawberry glaze'), 150),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from RESTAURANTS where NAME = 'Doughnuts & Coffee'), (Select id from dishes where name = 'Hot chocolate'), 315),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from RESTAURANTS where NAME = 'Doughnuts & Coffee'), (Select id from dishes where name = 'Doughnut with banana filling'), 165);

INSERT INTO rating(id, id_user, assessment, id_restaurant)
VALUES (NEXT VALUE FOR GLOBAL_SEQ, (select id from USERS where name = 'UserBob'), 5, (select id from RESTAURANTS where NAME = 'Il Patio')),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from USERS where name = 'UserAngelina'), 4, (select id from RESTAURANTS where NAME = 'Il Patio')),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from USERS where name = 'AdminSteve'), 3, (select id from RESTAURANTS where NAME = 'Il Patio')),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from USERS where name = 'AdminCarmen'), 5, (select id from RESTAURANTS where NAME = 'Il Patio')),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from USERS where name = 'UserBob'), 4, (select id from RESTAURANTS where NAME = 'Doughnuts & Coffee')),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from USERS where name = 'UserAngelina'), 2, (select id from RESTAURANTS where NAME = 'Doughnuts & Coffee')),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from USERS where name = 'AdminSteve'), 4, (select id from RESTAURANTS where NAME = 'Doughnuts & Coffee')),
       (NEXT VALUE FOR GLOBAL_SEQ, (select id from USERS where name = 'AdminCarmen'), 4, (select id from RESTAURANTS where NAME = 'Doughnuts & Coffee'));

commit;