create database veterinariaABC;

use veterinariaABC;

create table personas(
documento varchar(10)not null primary key,
telefono int,
nombre varchar(30));

create table mascotas(
idMascota int auto_increment primary key,
raza varchar (20),
nombre varchar(20),
sexo varchar (1),
IDdueno varchar(10),
foreign key (IDdueno) references personas(documento)); 