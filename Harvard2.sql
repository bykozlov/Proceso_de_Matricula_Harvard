create database ProyectoHarvard_20222;
use ProyectoHarvard_20222;

create table tbestadoalm /*Matriculado o retirado*/
(
idEstado int primary key auto_increment,
nom_Alm varchar(25)
);

insert into tbestadoalm values(null, 'Matriculado');
insert into tbestadoalm values(null, 'Retirado');

create table tbtrabaja /*Coordinador o secretaria*/
(
idEstado_Tra int primary key,
nom_Tra varchar(25)
);

create table tb_carrera(
	cod_carrera int primary key auto_increment,
	nombre varchar(50)
);


insert into tb_carrera values(null,'Computación');
insert into tb_carrera values(null,'Redes');
insert into tb_carrera values(null,'Anilisización de datos');

create table tb_alumno
(
idAlumno int primary key auto_increment,
nom_alm varchar(50),
ape_alm varchar(50),
dni_alm int unique,
celar_alm char(9),
edad char(2),
sexo char(1),
FechaRegistro date,
check(edad>=18),
check(Sexo in ('F','M'))
);

insert into tb_alumno values(null,'Aaron', 'Saavedra','14725836','956123258','18','M','2004/05/25');
insert into tb_alumno values(null,'Moises', 'Saavedra','73617739','987917009','18','M','2001/02/12');
select * from tb_Alumno;


create table tb_solicitante(
dni int primary key,
nom_soli varchar(50),
ape_soli varchar(50),
correo varchar(50),
edad char(2),
sexo char(1),
celular char(9),
check(edad>=18),
check(Sexo in ('F','M'))
);


create table tipoemple
(
codtipoUsu int primary key auto_increment,
nombreusu varchar(50)
);
insert into tipoemple values(null,'Coordinador/a');
insert into tipoemple values(null,'Secretaria(o)');
insert into tipoemple values(null,'Agente Ventas');

create table registro(
idRegistro int auto_increment not null,
codusu int,
usuario varchar(45) not null,
clave varchar(45) not null,
nom varchar(45) not null,
ape varchar(45) not null,
correo varchar(45) not null,
fechaDeIngreso datetime,
primary key (idRegistro),
foreign key (codusu) references tipoemple(codtipoUsu)
);
insert into registro values(null,1,'jorge','jorgito123','aron','chavez','jorgito09.82chavez@gmail.com',current_date());
select * from registro;
create table tb_Asignatura(
	cod_Asig int auto_increment primary key,
	nombre_Asig varchar(80) not null,
	creditos int not null,
	nivel int not null
);
create table TB_EstudianteAsigantura(
	codregistro int primary key auto_increment,
	idAlumno int,
	cod_curso int,
	nota1 int,
	nota2 int,
	nota3 int,
	nota4 int,
    foreign key(idAlumno ) references tb_Alumno(idAlumno),
	foreign key (cod_curso) references tb_curso(cod_curso)
);

create table tb_ciclo(
    codCiclo int primary key auto_increment,
    nomCiclo varchar(25)
);

insert into tb_ciclo values(null,'Primero');
insert into tb_ciclo values(null,'Segundo');
insert into tb_ciclo values(null,'Tercero');
insert into tb_ciclo values(null,'Cuarto');
insert into tb_ciclo values(null,'Quinto');
insert into tb_ciclo values(null,'Sexto');

create table tb_curso(
    cod_curso int primary key auto_increment,
    asig_curso varchar(40),
    credi_curso int,
    horas_curso int,
    codCiclo int,
    foreign key (codCiclo) references tb_ciclo(codCiclo)
);



create table tb_RegMatricula(
 codMatricula int primary key auto_increment,
 idAlumno int,
 codCiclo int,
 cod_carrera int,
 idEstado int,
 fecha date,
 foreign key (idAlumno)  references tb_alumno(idAlumno),
 foreign key(codCiclo) references tb_ciclo(codCiclo),
 foreign key(cod_carrera) references tb_carrera(cod_carrera),
 foreign key(idEstado) references tbestadoalm(idEstado)
);


create table tbCarreraCur(
codCarreCur int primary key auto_increment,
CodCarrera int,
cod_curso int,
foreign key (cod_curso) references tb_curso(cod_curso),
foreign key (CodCarrera) references tb_carrera(cod_carrera)
);

