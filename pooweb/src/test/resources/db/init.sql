create database r_empleados;

\connect r_empleados;

create table empleados (
  codigo bigint generated always as identity primary key,
  nombre character varying(100) not null,
  estado character varying(10) not null

);

insert into empleados (nombre,estado) values ('Luis Pedro','activo'), 
('Mario Lopez','inactivo'), 
('Luis Perez','activo');