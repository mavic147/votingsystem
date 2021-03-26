DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS rating;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS GLOBAL_SEQ;

CREATE SEQUENCE GLOBAL_SEQ START WITH 100000;

CREATE TABLE roles
(
    id INT DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX roles_unique_name_idx ON roles (name);

CREATE TABLE users
(
    id INT DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    registered TIMESTAMP DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    id_user INT NOT NULL,
    id_role INT NOT NULL,
    PRIMARY KEY (id_user, id_role),
    FOREIGN KEY (id_user) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (id_role) REFERENCES roles(id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
    id INT DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_name_idx ON restaurants (name);

CREATE TABLE menu
(
    id INT DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    id_restaurant INTEGER NOT NULL,
    name_dish VARCHAR(200) NOT NULL,
    price_dish INTEGER NOT NULL,
    date_last TIMESTAMP DEFAULT now() NOT NULL,
    deleted BOOLEAN DEFAULT FALSE NOT NULL,
    FOREIGN KEY (id_restaurant) REFERENCES restaurants(id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX menu_unique_dishname_restaurant_idx ON menu (id_restaurant, name_dish);

CREATE TABLE rating
(
    id INT DEFAULT GLOBAL_SEQ.nextval PRIMARY KEY,
    id_user INT NOT NULL,
    assessment INT NOT NULL,
    id_restaurant INT NOT NULL,
    date_create TIMESTAMP DEFAULT now() NOT NULL,
    FOREIGN KEY (id_restaurant) REFERENCES restaurants(id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX rating_unique_users_assessment_on_date_idx ON rating (id_user, assessment, date_create);