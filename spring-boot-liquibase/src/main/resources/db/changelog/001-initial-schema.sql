--liquibase formatted sql

-- changeset jon:1
create table person (
  id        int         not null primary key,
  firstname varchar(80),
  lastname  varchar(80) not null,
  state     varchar(2)
);
