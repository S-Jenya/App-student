--liquibase formatted sql

--changeset EvgenijSyomin:1
--Создание базы данных

create table student(
    id serial primary key,
    sname varchar not null,
    fname varchar not null,
    pname varchar
);

create table discipline (
    id serial primary key,
    id_student integer not null,
    name varchar not null,
    hours integer not null,

    CONSTRAINT discipline_id_student_fk FOREIGN KEY(id_student) REFERENCES student(id)
);


create table classes
(
    id serial primary key,
    id_discipline integer not null,
    name varchar not null,
    dtstart Date not null,
    dtend Date,
    grade integer,
    description varchar,

    CONSTRAINT classes_id_discipline_fk FOREIGN KEY(id_discipline) REFERENCES discipline(id)
);


insert into student(sname, fname, pname) values ('Иванов', 'Иван', 'Иванович');
insert into student(sname, fname, pname) values ('Сёмин', 'Евгений', 'Николаевич');