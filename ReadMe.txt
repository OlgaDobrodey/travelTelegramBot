1.Rest WebService для управления данными о городаx:
 http://localhost:8080/bot/

2. Данные базы данных postgresql :

server.servlet.context-path=/bot
spring.datasource.url=jdbc:postgresql://localhost:5432/bot
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=123456

3. База данных:
3.1. Создание базы данных
CREATE DATABASE bot
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

3.2 Создание схемы
CREATE SCHEMA bot
    AUTHORIZATION postgres;

3.3 Создание таблицы
CREATE TABLE IF NOT EXISTS bot.cities
(
    id integer NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    information text COLLATE pg_catalog."default",
    CONSTRAINT cities_pkey PRIMARY KEY (id),
    CONSTRAINT cities_name_key UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE bot.cities
    OWNER to postgres;

3.4 Заполнение таблицы данными:
INSERT INTO bot.cities(
	id, name, information)
	VALUES (8, 'Москва','Не забудьте посетить Красную Площадь. Ну а в ЦУМ можно и не заходить)))');

4. Данные телеграм бота
    bot.name= my_experiment_travel_bot
    bot.token= 1972646108:AAFHQcytjai-1ZfqAq6qJ0Zc_yp7lF2EnRk

5. Запуск DemoApplication.java (src/main/java/com/experiment/travel/DemoApplication.java)

