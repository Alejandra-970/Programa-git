-- Insertar roles y permisos 

insert into Roles (nombreRol) values ('admin');
insert into Permisos (nombrePermiso) values ('crear');
insert into Permisos (nombrePermiso) values ('editar');
insert into Permisos (nombrePermiso) values ('ver');
insert into Permisos (nombrePermiso) values ('eliminar');
insert into PermisosRoles (idRol, idPermiso)
select (select idRol from Roles where nombreRol = 'admin'), idPermiso from Permisos; 

-- Etapas Kanban

insert into EtapaKanban (nombreEtapa, tipo, categoria) 
values ('Nuevo Cliente', 'Cliente', 'Primera Fase');
insert into EtapaKanban (nombreEtapa, tipo, categoria) 
values ('Evaluación', 'Expediente', 'Fase Inicial');
insert into EtapaKanban (nombreEtapa, tipo, categoria) 
values ('En Progreso', 'Tarea', 'Tareas Activas');

-- Contacto = Usuario Administrador

insert into  Contactos (idContacto, nombre, correo, tipoContacto, esUsuario, creadoPor)
values (UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440001'), 'Admin', 'admin@email.com', 'trabajador', true, UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440001'));

-- Crear Usuario Administrador

insert into Usuarios (idUsuario, idContacto, contraseña, idRol) 
values (UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'), UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440001'), 'contraseña123',
	(select idRol from Roles where nombreRol = 'admin'));
        
-- Crear Expedientes 

insert into Expediente (idExpediente, titulo, areaExpediente, estado, posicionExpediente, creadoPor, idEtapaKanban)
values (UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440002'), 'Caso López vs. Pérez', 'Civil', 'activo', 1, UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'), 2);

-- Anñadir mas contactos

insert into  Contactos (idContacto, nombre, correo, tipoContacto, esUsuario, creadoPor)
values (UUID_TO_BIN(UUID()), 'Cliente 1', 'cliente1@email.com', 'cliente', true, UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'));

-- Añadir un contacto a un expediente

INSERT INTO ExpedienteContacto (idRelacionEC, idExpediente, idContacto, rolContacto)
VALUES (UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440003'),  UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440002'), UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440001'), 'Abogado'), 
((UUID_TO_BIN(uuid()),  UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440002'), UUID_TO_BIN('dacc540a-f89b-11ef-bdac-7c70db288abf'), 'Juez'));

-- Añadir un documento

INSERT INTO Documento (idDocumento, fechaAgregado, nombre, origen, enlace, numeracion, creadoPor)
VALUES (UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440004'), NOW(), 'Contrato de Arrendamiento', 'Cliente', 'http://docs.com/contrato.pdf', 1, UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'));
INSERT INTO Documento (idDocumento, nombre, origen, enlace, creadoPor)
VALUES (UUID_TO_BIN(UUID()), 'Demanda', 'Abogado', 'http://docs.com/contrato.pdf', UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'));

-- Añadir Documento a un expediente

insert into DocumentoExpediente (idRelacionDE, idExpediente, idDocumento)
values (UUID_TO_BIN(UUID()),UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440002'),UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440004')), 
(UUID_TO_BIN(UUID()),UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440002'),UUID_TO_BIN('bd4eb071-f89d-11ef-bdac-7c70db288abf'));

-- Añadir Notas

insert into Nota (idNota, contenido, fechaCreacion, posicionNota, creadoPor, tipoNota)
values (UUID_TO_BIN(UUID()),'Revisar documentación antes del viernes.', NOW(), 1, UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'),'Relacionada'); 

select bin_to_uuid(idNota) idNota, contenido from Nota;

-- Relacionar Nota con Expediente

insert into NotaExpediente (idRelacionNE, idNota, idExpediente)
values (UUID_TO_BIN(UUID()), UUID_TO_BIN('6169be24-f8a0-11ef-bdac-7c70db288abf'), UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440002'));

-- Agregar Tarea 

insert into Tarea (idTarea, nombreTarea, descripcionTarea, fechaVencimiento, estadoTarea, creadoPor, asignadaA, idEtapaKanban)
values (UUID_TO_BIN(UUID()), 'Primeros Pasos' , 'Solicitar documentos al cliente', '2025-05-01', 'en Progreso', UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'), UUID_TO_BIN('dacc540a-f89b-11ef-bdac-7c70db288abf'), 3);

select bin_to_uuid(idTarea) idTarea, nombreTarea from Tarea;

-- Relacionar Tarea con Expediente

insert into TareaExpediente (idRelacionTE, idTarea, idExpediente)
values (UUID_TO_BIN(UUID()), UUID_TO_BIN('ace660a4-f8a1-11ef-bdac-7c70db288abf'), UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440002'));

-- Relacionar Tarea con Contacto 

insert into TareaContacto (idRelacionTC, idTarea, idContacto)
values (UUID_TO_BIN(UUID()), UUID_TO_BIN('ace660a4-f8a1-11ef-bdac-7c70db288abf'), UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440001'));

-- Consultar UUID de los registros en tabla Contactos y Expediente
select * from contactos;
select bin_to_uuid(idContacto) idContacto, nombre from contactos;
select * from ExpedienteContacto;
select * from Expediente;
select bin_to_uuid(idExpediente) idExpediente, areaExpediente from Expediente;



