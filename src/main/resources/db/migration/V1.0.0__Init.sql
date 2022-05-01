CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

SET search_path TO pointr,public;

CREATE SCHEMA IF NOT EXISTS pointr;


CREATE TABLE IF NOT EXISTS pointr.business(
    id            uuid primary key,
    name          varchar(20)  not null,
    description   text         not null,
    cta           varchar(100) not null,
    creation_time timestamp    not null,
    update_time   timestamp,
);

CREATE TABLE IF NOT EXISTS pointr.product(
    id            uuid primary key,
    name          varchar(20)  not null,
    business_id   uuid         not null references pointr.business,
    creation_time timestamp    not null,
    update_time   timestamp,
)
