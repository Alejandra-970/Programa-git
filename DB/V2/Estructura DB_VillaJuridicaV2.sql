drop database villa_juridica;
create database villa_juridica; 
use villa_juridica;

-- TABLA VISTA TABLERO KANBAN -- 

create table EtapaKanban (
idEtapaKanban int auto_increment primary key, 
nombreEtapa varchar(100) not null, 
tipo varchar(100) check (tipo in ('expediente', 'cliente potencial','tarea', 'nota', 'evento', 'documento')) not null, 
categoria varchar(100)
);

-- TABLA CONTACTOS

create table Contactos (
idContacto binary(16) primary key, 
persona enum('natural', 'juridica', 'sin asignar') default 'sin asignar',
documento varchar(50), 
nombre varchar(255) not null, 
segundoNombre varchar(255),
apellido varchar(255),
correo varchar(255),
tel varchar(20),
ciudad varchar(255),
tipoContacto varchar(100) not null, 
posicionContacto int, 
idEtapaKanban int, 
esUsuario bool default false, 
entidad varchar(255),
especialidad varchar(255), 
rolTrabajador varchar(255),
creadoPor binary(16) not null, 
constraint fk_etapa_kanban foreign key (idEtapaKanban) references EtapaKanban(idEtapaKanban) on delete cascade on update cascade,
constraint chk_usuario check ((esUsuario = true and tipoContacto in ('trabajador', 'cliente')) or esUsuario = false)
);

-- TABLA EXPEDIENTES 

create table Expediente (
idExpediente binary(16) primary key, 
titulo varchar(255) not null, 
areaExpediente enum('Civil', 'laboral', 'penal', 'administrativo', 'familia', 'especialidad sin nombre') default 'especialidad sin nombre', 
descripción text, 
fechaApertura timestamp, 
fechaCierre date, 
precio decimal, 
estado varchar(50) check(estado in('activo', 'archivado')) not null, 
posicionExpediente int not null, 
creadoPor binary(16) not null,
idEtapaKanban int,
constraint fk_etapa_kanban_expediente foreign key (idEtapaKanban) references EtapaKanban(idEtapaKanban) on delete cascade on update cascade
);

-- TABLA EXPEDIENTE - CONTACTO 

create table ExpedienteContacto (
idRelacionEC binary(16) primary key,
idExpediente binary(16) not null, 
idContacto binary(16), 
rolContacto varchar(255) not null,
constraint fk_expediente_contacto foreign key(idExpediente) references Expediente(idExpediente) on delete cascade on update cascade,
constraint fk_contacto_expediente foreign key(idContacto) references Contactos(idContacto) on delete cascade on update cascade
);

-- TABLA DOCUMENTO 

create table Documento (
idDocumento binary(16) primary key, 
fechaAgregado timestamp, 
nombre varchar(255) not null, 
origen varchar(255) not null, 
enlace text, 
numeracion int not null,
creadoPor binary(16) not null
);

-- TABLA EXPEDIENTE - DOCUMENTO 

create table DocumentoExpediente(
idRelacionDE binary(16) primary key, 
idExpediente binary(16) not null, 
idDocumento binary(16) not null, 
constraint fk_expediente_documento foreign key(idExpediente) references Expediente(idExpediente) on delete cascade on update cascade,
constraint fk_documento_expediente foreign key(idDocumento) references Documento(idDocumento) on delete cascade on update cascade
);

-- TABLA NOTAS --

create table Nota(
idNota binary(16) primary key,
contenido text not null, 
fechaCreacion timestamp,
posicionNota int not null,  
creadoPor binary(16) not null,
tipoNota varchar(50) check(tipoNota in('Personal', 'Relacionada')) not null
);

-- TABLA NOTA - CONTACTO 

create table NotaContacto(
idRelacionNC binary(16) primary key,
idNota binary(16) not null, 
idContacto binary(16),  
constraint fk_nota_contacto foreign key(idNota) references Nota(idNota) on delete cascade on update cascade,
constraint fk_contacto_nota foreign key(idContacto) references Contactos(idContacto) on delete cascade on update cascade
);

-- TABLA NOTA - EXPEDIENTE

create table NotaExpediente(
idRelacionNE binary(16) primary key,
idNota binary(16) not null, 
idExpediente binary(16),  
constraint fk_nota_expediente foreign key(idNota) references Nota(idNota) on delete cascade on update cascade,
constraint fk_expediente_nota foreign key(idExpediente) references Expediente(idExpediente) on delete cascade on update cascade
);

-- TABLA TAREAS 

create table Tarea(
idTarea binary(16) primary key,
esPrivado bool default false,
nombreTarea varchar(255), 
descripcionTarea text not null, 
fechaVencimiento date,
posicionTarea int not null,
creadoPor binary(16) not null, 
idEtapaKanban int, 
constraint fk_etapa_kanban_Tarea foreign key (idEtapaKanban) references EtapaKanban(idEtapaKanban) on delete cascade on update cascade
);

-- TABLA TAREA - EXPEDIENTE 

create table TareaExpediente(
idRelacionTE binary(16) primary key,
idTarea binary(16) not null,
idExpediente binary(16),
constraint fk_expediente_tarea foreign key(idExpediente) references Expediente(idExpediente) on delete cascade on update cascade,
constraint fk_tarea_expediente foreign key(idTarea) references Tarea(idTarea) on delete cascade on update cascade
);

-- TABLA TAREA - CONTACTO

create table TareaContacto(
idRelacionTC binary(16) primary key,
idTarea binary(16) not null,
idContacto binary(16),
constraint fk_contacto_tarea foreign key(idContacto) references Contactos(idContacto) on delete cascade on update cascade, 
constraint fk_tarea_contacto foreign key(idTarea) references Tarea(idTarea) on delete cascade on update cascade
);

-- TABLA EVENTOS

create table Evento(
    idEvento binary(16) primary key,
    titulo varchar(255),
    fechaHora timestamp,
    tipoEvento enum('Reunion', 'Audiencia', 'Intake', 'otro', 'Sin Asignar') default 'Sin Asignar',
	lugar varchar(255) not null, 
    posicionEvento int not null,
	creadoPor binary(16) not null
);

-- TABLA EVENTO - CONTACTO

create table EventoContacto(
    idRelacionEC binary(16) primary key,
    idEvento binary(16),
    idContacto binary(16),
    constraint fk_evento_contacto foreign key (idEvento) references Evento(idEvento) on delete cascade,
    constraint fk_contacto_evento foreign key (idContacto) references Contactos(idContacto) on delete cascade
);

-- TABLA EVENTO - EXPEDIENTE

create table ExpedienteEvento (
    idRelacionEE binary(16) primary key,
    idExpediente binary(16),
    idEvento binary(16),
    constraint fk_expediente_evento foreign key (idExpediente) references Expediente(idExpediente) on delete cascade,
    constraint fk_evento_expediente foreign key (idEvento) references Evento(idEvento) on delete cascade
);	

-- TABLA ROLES

create table Roles(
idRol int auto_increment primary key, 
nombreRol varchar(100) not null unique
);

-- TABLA USUARIOS

create table Usuarios(
idUsuario binary(16) primary key,
idContacto binary(16),
contraseña varchar(255) not null, 
idRol int not null, 
estado enum('activo','iactivo') default 'activo',
constraint fk_usuario_contacto foreign key(idContacto) references Contactos(idContacto) on delete cascade on update cascade, 
constraint fk_usuario_rol foreign key(idRol) references Roles(idRol) on delete cascade on update cascade
);

-- TABLA PERMISOS

create table Permisos(
idPermiso int auto_increment primary key, 
nombrePermiso varchar(100) not null unique
);

-- TABLA PERMISOS - ROLES
create table PermisosRoles(
idRol int not null, 
idPermiso int not null, 
primary key (idRol, idPermiso), 
constraint fk_rol_permiso foreign key(idRol) references Roles(idRol) on delete cascade on update cascade, 
constraint fk_permiso_rol foreign key(idPermiso) references Permisos(idPermiso) on delete cascade on update cascade
);

-- TABLA PARA COMPARTIR NOTAS, TAREAS Y EVENTOS

create table CompartirElemento (
    idRelacionCE binary(16) primary key,
    idUsuario binary(16) not null,
    idTarea binary(16),
    idNota binary(16),
    idEvento binary(16),
    constraint fk_usuario_compartir foreign key (idUsuario) references Usuarios(idUsuario) on delete cascade on update cascade,
    constraint fk_tarea_compartir foreign key (idTarea) references Tarea(idTarea) on delete cascade on update cascade,
    constraint fk_nota_compartir foreign key (idNota) references Nota(idNota) on delete cascade on update cascade, 
    constraint fk_evento_compartir foreign key (idEvento) references Evento(idEvento) on delete cascade on update cascade
);

-- SECCION DE TRIGGERS 

-- CONTACTOS
delimiter //
create trigger before_insert_contactos
before insert on Contactos
for each row
begin
    declare maxPos int;
    select IFNULL(MAX(posicionContacto), 0) + 1 into maxPos from Contactos;
    set new.posicionContacto = maxPos;

    if not exists (select 1 from Usuarios where idUsuario = new.creadoPor) then
        signal sqlstate '45000' set message_text = 'El usuario que intenta crear el contacto no existe';
    end if;
end;
//
delimiter ;

-- EXPEDIENTES

delimiter //

create trigger before_insert_expediente
before insert on Expediente
for each row
begin
    declare maxPos int;
    select IFNULL(MAX(posicionExpediente), 0) + 1 into maxPos from Expediente;
    set new.posicionExpediente = maxPos;

    if not exists (select 1 from Usuarios where idUsuario = new.creadoPor) then
        signal sqlstate '45000' set message_text = 'El usuario que intenta crear el expediente no existe';
    end if;
end;
//

delimiter ;

-- DOCUMENTOS

delimiter //

create trigger before_insert_documento
before insert on Documento
for each row
begin
    declare maxPos int;
    select IFNULL(MAX(numeracion), 0) + 1 into maxPos from Documento;
    set new.numeracion = maxPos;

    if not exists (select 1 from Usuarios where idUsuario = new.creadoPor) then
        signal sqlstate '45000' set message_text = 'El usuario que intenta crear el documento no existe';
    end if;
end;
//

delimiter ;

-- NOTAS

delimiter //

create trigger before_insert_nota
before insert on Nota
for each row
begin
    declare maxPos int;
    select IFNULL(MAX(posicionNota), 0) + 1 into maxPos from Nota;
    set new.posicionNota = maxPos;

    if not exists (select 1 from Usuarios where idUsuario = new.creadoPor) then
        signal sqlstate '45000' set message_text = 'El usuario que intenta crear la nota no existe';
    end if;
end;
//

delimiter ;

-- TAREAS

Delimiter //

create trigger before_insert_tarea
before insert on Tarea
for each row
begin
    declare maxPos int;
    select IFNULL(MAX(posicionTarea), 0) + 1 into maxPos from Tarea;
    set new.posicionTarea = maxPos;
    
    if not exists (select 1 from Usuarios where idUsuario = new.creadoPor) then
        signal sqlstate '45000' set message_text = 'El usuario que intenta crear la nota no existe';
    end if;
end;
//

delimiter ;

-- EVENTOS

Delimiter //

create trigger before_insert_evento
before insert on Evento
for each row
begin
    declare maxPos int;
    select IFNULL(MAX(posicionEvento), 0) + 1 into maxPos from Evento;
    set new.posicionEvento = maxPos;
    
    if not exists (select 1 from Usuarios where idUsuario = new.creadoPor) then
        signal sqlstate '45000' set message_text = 'El usuario que intenta crear la nota no existe';
    end if;
end;
//

delimiter ;	

-- COMPARTIR TAREAS/NOTAS/EVENTOS A USUARIOS ACTIVOS

delimiter //

create trigger before_insert_compartir_elemento
before insert on CompartirElemento
for each row
begin
    declare usuario_activo int;
    declare existe_relacion int;

    select count(*) into usuario_activo from Usuarios where idUsuario = new.idUsuario and estado = 'activo';
    
    if usuario_activo = 0 then
        signal sqlstate '45000'
        set message_text = 'no se puede compartir con un usuario inactivo o inexistente.';
    end if;

    select count(*) into existe_relacion 
    from CompartirElemento 
    where idUsuario = new.idUsuario and 
          ((idTarea is not null and idTarea = new.idTarea) or 
           (idNota is not null and idNota = new.idNota) or
           (idEvento is not null and idEvento = new.idEvento));

    if existe_relacion > 0 then
        signal sqlstate '45000'
        set message_text = 'el usuario ya tiene acceso a esta tarea o nota.';
    end if;
end;
//

delimiter ;

delimiter //

create trigger before_update_compartir_elemento
before update on CompartirElemento
for each row
begin
    declare usuario_activo int;

    select count(*) into usuario_activo 
    from Usuarios 
    where idUsuario = new.idUsuario and estado = 'activo';
    
    if usuario_activo = 0 then
        signal sqlstate '45000'
        set message_text = 'no se puede reasignar a un usuario inactivo o inexistente.';
    end if;
end;
//

delimiter ;

-- ACTUALIZAR ESTADO DE UNA TAREA

delimiter //

create trigger after_update_estado_kanban
after update on EtapaKanban
for each row
begin
    
    update Tarea
    set estado = new.nombreEtapa
    where idEtapaKanban = new.idEtapaKanban;
end;
//

delimiter ;