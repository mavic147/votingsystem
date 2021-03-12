DROP TABLE user_roles IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE roles IF EXISTS;
DROP TABLE menu IF EXISTS;
DROP TABLE rating IF EXISTS;
DROP TABLE restaurants IF EXISTS;
DROP TABLE dishes IF EXISTS;
DROP SEQUENCE GLOBAL_SEQ IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ START WITH 100000;

CREATE TABLE roles
(
    id_role INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE users
(
    id_user INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    registered TIMESTAMP DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    id_user INTEGER NOT NULL,
    id_role INTEGER NOT NULL,
    FOREIGN KEY (id_user) REFERENCES users(id_user) ON DELETE CASCADE,
    FOREIGN KEY (id_role) REFERENCES roles(id_role) ON DELETE CASCADE,
    PRIMARY KEY (id_user, id_role)
);

CREATE TABLE restaurants
(
    id_restaurant INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    name VARCHAR(200) NOT NULL
);

CREATE TABLE dishes
(
    id_dish INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    name VARCHAR(200) UNIQUE NOT NULL
);
CREATE UNIQUE INDEX dishes_unique_name_idx ON dishes(name);

CREATE TABLE menu
(
    id_menu INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    id_restaurant INTEGER NOT NULL,
    id_dish INTEGER NOT NULL,
    price_dish INTEGER NOT NULL,
    date_last TIMESTAMP NOT NULL,
    FOREIGN KEY (id_restaurant) REFERENCES restaurants(id_restaurant) ON DELETE CASCADE,
    FOREIGN KEY (id_dish) REFERENCES dishes(id_dish) ON DELETE CASCADE
);

CREATE TABLE rating
(
    id_rating INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    id_user INTEGER NOT NULL,
    assessment INTEGER NOT NULL,
    id_restaurant INTEGER NOT NULL,
    date_create TIMESTAMP NOT NULL,
    FOREIGN KEY (id_restaurant) REFERENCES restaurants(id_restaurant) ON DELETE CASCADE
);
CREATE UNIQUE INDEX rating_unique_assessment_idx ON rating(assessment);