CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SET search_path TO data,public;

CREATE SCHEMA IF NOT EXISTS data;


CREATE TABLE IF NOT EXISTS data.business(
    id            uuid primary key,
    name          varchar(20)  not null,
    description   text         not null,
    cta           varchar(100) not null,
    creation_time timestamp    not null,
    update_time   timestamp,
);

CREATE TABLE IF NOT EXISTS data.product(
    id            uuid primary key,
    name          varchar(20)  not null,
    business_id   uuid         not null references data.business,
    creation_time timestamp    not null,
    update_time   timestamp,
)
