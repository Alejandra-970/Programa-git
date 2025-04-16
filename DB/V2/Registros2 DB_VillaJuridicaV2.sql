-- CREAR ROLES 
insert into Roles (nombreRol) values ('administrador'),('trabajador'), ('cliente');

-- CREAR ETAPAS EN KANABN 
insert into EtapaKanban (nombreEtapa, tipo, categoria) 
values ('Nuevo Expediente', 'expediente', 'Inicial'),
('Cliente Potencial Contactado', 'cliente potencial', 'Seguimiento'),
('Tarea Pendiente', 'tarea', 'Pendientes'),
('Nota Importante', 'nota', 'General'),
('Audiencia Programada', 'evento', 'Judicial');

-- CREAR USUARIOS 
insert into Usuarios (idUsuario, idContacto, idRol, contraseña) values (UUID_TO_BIN(UUID()), (SELECT idContacto FROM Contactos WHERE correo = 'juanperez@email.com'), 2, 'hashed_password');

select bin_to_uuid(idUsuario) idUsuario from Usuarios;

-- AGREGAR CONTACTOS 
insert into Contactos (idContacto, persona, documento, nombre, apellido, correo, tel, ciudad, tipoContacto, esUsuario, rolTrabajador, creadoPor)
values (UUID_TO_BIN(UUID()), 'natural', '12345678', 'Juan', 'Pérez', 'juanperez@email.com', '3012345678', 'Bogotá', 'trabajador', true, 'Abogado', UUID_TO_BIN('d76f9624-f9fd-11ef-bdac-7c70db288abf')),
(UUID_TO_BIN(UUID()), 'juridica', '900123456', 'Empresa ABC', null, 'contacto@empresaabc.com', '6012345678', 'Medellín', 'cliente', false, NULL, UUID_TO_BIN('d76f9624-f9fd-11ef-bdac-7c70db288abf'));

select * from Contactos;

-- CREAR EXPEDIENTES
insert into Expediente(idExpediente, titulo, areaExpediente, descripción, estado, posicionExpediente, creadoPor)
values (UUID_TO_BIN(UUID()), 'Ejecutivo de Mínima Cuantía', 'Civil', 'Demanda por incumplimiento de contrato', 'activo', 1, (UUID_TO_BIN('d76f9624-f9fd-11ef-bdac-7c70db288abf')));

select * from Expediente;

-- AGREGAR DOCUMENTOS 
insert into Documento (idDocumento, fechaAgregado, nombre, origen, enlace, creadoPor) 
values (UUID_TO_BIN(UUID()), now(), 'Contrato_Compraventa.pdf', 'Cliente', 'http://example.com/documentos/contrato_compra.pdf', (UUID_TO_BIN('d76f9624-f9fd-11ef-bdac-7c70db288abf')));

select * from Documento;

-- VINCULAR CONTRATO A EXPEDIENTE
insert into DocumentoExpediente (idRelacionDE, idExpediente, idDocumento)
values(UUID_TO_BIN(UUID()), (Select idExpediente from Expediente limit 1), (select idDocumento from Documento limit 1));

select * from DocumentoExpediente;

-- CREAR NUEVA NOTA 
insert into Nota(idNota, contenido, fechaCreacion, creadoPor, tipoNota)
values (UUID_TO_BIN(UUID()), 'Borrador: Alegatos de conclusión y Recurso de Apelación', now(), (UUID_TO_BIN('d76f9624-f9fd-11ef-bdac-7c70db288abf')),'Personal'); 

select * from Nota;

-- CREAR NUEVA TAREA 	
insert into Tarea(idTarea, esPrivado, nombreTarea, descripcionTarea, fechaVencimiento, creadoPor, idEtapaKanban)
values (UUID_TO_BIN(UUID()), false, 'Demanda', 'Revisar contrato de compraventa y Redactar primer borrador de demanda', '2025-03-20', (SELECT idUsuario FROM Usuarios LIMIT 1), 3);

select * from Tarea; 

-- AGREGAR NUEVO EVENTO 
insert into Evento(idEvento, titulo, fechaHora, tipoEvento, lugar, creadoPor)
values (UUID_TO_BIN(UUID()), 'Audiencia Inicial', '2025-04-02 09:00:00', 'Audiencia', 'https://meet.google.com/eun-bpvp-crh ', (SELECT idUsuario FROM Usuarios LIMIT 1));

select * from Evento;

-- CREAR NUEVA NOTA Y VINCULAR A EXPEDIENTE 

insert into Nota(idNota, contenido, fechaCreacion, tipoNota, creadoPor) 
VALUES (UUID_TO_BIN(UUID()), 'Se discutio la estrategia con el cliente y este quiere conciliar antes de demanda.', NOW(), 'Relacionada', (SELECT idUsuario FROM Usuarios LIMIT 1));
select bin_to_uuid(idNota) idNota from Nota;
insert into NotaExpediente (idRelacionNE, idExpediente, idNota)
values (UUID_TO_BIN(UUID()), (Select idExpediente from Expediente limit 1),(UUID_TO_BIN('638d9442-fa04-11ef-bdac-7c70db288abf')));



