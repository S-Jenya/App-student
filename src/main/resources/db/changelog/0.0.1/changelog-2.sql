--liquibase formatted sql

--changeset EvgenijSyomin:2
--Изменение настроек таблицы "Занятия"
ALTER TABLE classes
    ALTER COLUMN dtend DROP NOT NULL;