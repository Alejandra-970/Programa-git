drop database villa_juridica;
create database villa_juridica; 
use villa_juridica;

-- TABLA ROLES

create table Roles(
idRol int auto_increment primary key, 
nombreRol varchar(100) not null unique
);

select * from Roles;

-- TABLA VISTA TABLERO KANBAN -- 

create table EtapaKanban (
idEtapaKanban int auto_increment primary key, 
nombreEtapa varchar(100) not null, 
tipo varchar(100) check (tipo in ('expediente', 'cliente potencial','tarea', 'nota', 'evento', 'documento')) not null, 
categoria varchar(100)
);

select * from EtapaKanban;

-- TABLA CONTACTO

create table Contactos (
idContacto binary(16) primary key default (UUID_TO_BIN(UUID())),
persona enum('natural', 'juridica', 'sin asignar') default 'sin asignar',
tipoDocumento enum('C.C.', 'NIT', 'Pasaporte', 'sin asignar') default 'sin asignar',
documento varchar(50), 
nombre varchar(255) not null, 
segundoNombre varchar(255),
apellido varchar(255),
correo varchar(255),
tel varchar(20),
direccion varchar (255),
ciudad varchar(255),
tipoContacto varchar(100) default 'sin asignar',
idEtapaKanban int,  
entidad varchar(255),
especialidad varchar(255),
creadoPor binary(16) not null,
esUsuario bool default false, 
idRol int,
contraseña varchar(255),
estadoUsuario enum('activo', 'inactivo') default 'inactivo',
constraint fk_etapa_kanban foreign key (idEtapaKanban) references EtapaKanban(idEtapaKanban) on delete cascade on update cascade,
constraint fk_contacto_rol foreign key(idRol) references Roles(idRol) on delete cascade on update cascade
);

select * from Contactos;

-- TABLA EXPEDIENTES 

create table Expediente (
idExpediente binary(16) primary key default (UUID_TO_BIN(UUID())),
tituloExp varchar(255) not null, 
areaExpediente enum('Civil', 'laboral', 'penal', 'administrativo', 'familia', 'especialidad sin nombre') default 'especialidad sin nombre', 
descripcion text, 
fechaApertura timestamp default now(), 
fechaCierre date, 
precio decimal, 
radicado varchar(255),
fechaRadicado date,
ciudadExp varchar(255),
estadoExpediente varchar(50) check(estadoExpediente in('activo', 'archivado')) not null default "activo", 
creadoPor binary(16) not null,
idEtapaKanban int,
constraint fk_etapa_kanban_expediente foreign key (idEtapaKanban) references EtapaKanban(idEtapaKanban) on delete cascade on update cascade
);

select * from Expediente;

-- TABLA EXPEDIENTE - CONTACTO 

create table ExpedienteContacto (
idRelacionEC binary(16) primary key default (UUID_TO_BIN(UUID())),
idExpediente binary(16) not null, 
idContacto binary(16) not null, 
rolContacto varchar(255) not null,
constraint fk_expediente_contacto foreign key(idExpediente) references Expediente(idExpediente) on delete cascade on update cascade,
constraint fk_contacto_expediente foreign key(idContacto) references Contactos(idContacto) on delete cascade on update cascade
);

select * from ExpedienteContacto;

-- TABLA DOCUMENTO 

create table Documento (
idDocumento binary(16) primary key default (UUID_TO_BIN(UUID())),
fechaAgregado timestamp default now(), 
nombreDocumento varchar(255) default 'Nombre Pendiente', 
origenDocumento varchar(255), 
enlaceDocumento text,
creadoPor binary(16) not null
);
select * from Documento;

-- TABLA EXPEDIENTE - DOCUMENTO 

create table DocumentoExpediente(
idRelacionDE binary(16) primary key default (UUID_TO_BIN(UUID())),
idExpediente binary(16) not null, 
idDocumento binary(16) not null,
constraint fk_expediente_documento foreign key(idExpediente) references Expediente(idExpediente) on delete cascade on update cascade,
constraint fk_documento_expediente foreign key(idDocumento) references Documento(idDocumento) on delete cascade on update cascade
);

select * from DocumentoExpediente;

-- TABLA NOTAS 

create table Nota(
idNota binary(16) primary key default (UUID_TO_BIN(UUID())),
tituloNota varchar(255),
contenidoNota text not null, 
fechaCreacion timestamp default now(),
creadoPor binary(16) not null,
tipoNota enum('personal', 'relacionada') default 'personal',
idEtapaKanban int,
constraint fk_etapa_kanban_Nota foreign key (idEtapaKanban) references EtapaKanban(idEtapaKanban) on delete cascade on update cascade
);

select * from Nota;

-- TABLA 'RELACIONADA NOTAS'

create table NotaRelacion (
    idRelacionN binary(16) primary key default (UUID_TO_BIN(UUID())),
    idNota binary(16) not null,
    idExpediente binary(16),
    idContacto binary(16),
    constraint fk_nota_relacion foreign key(idNota) references Nota(idNota) on delete cascade on update cascade,
    constraint fk_nota_contacto  foreign key (idContacto) references Contactos(idContacto) on delete cascade on update cascade,
    constraint fk_nota_expediente foreign key(idExpediente) references Expediente(idExpediente) on delete cascade on update cascade
);

select * from NotaRelacion;

-- TABLA TAREAS 

create table Tarea(
idTarea binary(16) primary key default (UUID_TO_BIN(UUID())),
fechaCreacion timestamp default now(),
esPrivado bool default false,
nombreTarea varchar(255), 
descripcionTarea text not null, 
fechaVencimiento date,
prioridad enum('Baja', 'Media', 'Alta', 'Urgente', 'sin asignar') default 'sin asignar',
creadoPor binary(16) not null, 
idEtapaKanban int, 
constraint fk_etapa_kanban_Tarea foreign key (idEtapaKanban) references EtapaKanban(idEtapaKanban) on delete cascade on update cascade
);

select * from Tarea;

-- TABLA 'RELACIONADA' TAREA

create table TareaRelacion (
    idRelacionT binary(16) primary key default (UUID_TO_BIN(UUID())),
    idTarea binary(16) not null,
    idExpediente binary(16),
    idContacto binary(16),
    rolAsignado varchar(200),
    constraint fk_tarea_relacion foreign key(idTarea) references Tarea(idTarea) on delete cascade on update cascade,
    constraint fk_tarea_contacto  foreign key (idContacto) references Contactos(idContacto) on delete cascade on update cascade,
    constraint fk_tarea_expediente foreign key(idExpediente) references Expediente(idExpediente) on delete cascade on update cascade
);

select * from TareaRelacion;

-- TABLA EVENTOS

create table Evento(
    idEvento binary(16) primary key default (UUID_TO_BIN(UUID())),
    tituloEvento varchar(255),
    descripcionEvento text,
    fechaHoraInicio datetime,
    fechaHoraFin datetime,
    allDay boolean default false,
    recordatorio datetime,
    tipoEvento enum('Reunion', 'Audiencia', 'Intake', 'otro', 'Sin Asignar') default 'Sin Asignar',
	lugarEvento varchar(255),
    adjuntoEvento varchar(255),
	creadoPor binary(16) not null, 
    idEtapaKanban int,
	constraint fk_etapa_kanban_evento foreign key (idEtapaKanban) references EtapaKanban(idEtapaKanban) on delete cascade on update cascade
);

select * from Evento;

-- TABLA 'RELACIONADA' EVENTO

create table EventoRelacion(
    idRelacionE binary(16) primary key default (UUID_TO_BIN(UUID())),
    idEvento binary(16) not null,
	idExpediente binary(16),
    idContacto binary(16),
    constraint fk_evento_relacion foreign key (idEvento) references Evento(idEvento) on delete cascade,
    constraint fk_evento_contacto  foreign key (idContacto) references Contactos(idContacto) on delete cascade on update cascade,
    constraint fk_evento_expediente foreign key(idExpediente) references Expediente(idExpediente) on delete cascade on update cascade
);

select * from EventoRelacion;

-- TABLA NOTIFICACIONES

create table Notificaciones (
    idNotificacion binary(16) primary key default (UUID_TO_BIN(UUID())),
    idContacto binary(16) not null,
    tipoNotificacion varchar(50) default 'Alerta',
    mensaje text not null,
    leida bool default false,
    fechaCreacion timestamp default now(),
    constraint fk_notificacion_usuario foreign key (idContacto) references Contactos(idContacto) on delete cascade on update cascade
);

select * from Notificaciones;