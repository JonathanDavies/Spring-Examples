--liquibase formatted sql

-- changeset jon:1
create table items (
  id          serial not null
    constraint "ITEMS_pkey"
    primary key,
  description text
);

