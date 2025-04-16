use Villa_juridica;
insert into Roles(nombreRol) values('Administrador');
insert into EtapaKanban(nombreEtapa, tipo, categoria) values('Propuesta Enviada', 'Cliente Potencial', 'Civil');
insert into Contactos(idContacto, persona, tipoDocumento, documento, nombre, apellido, tipoContacto, creadoPor, esUsuario, idRol, estadoUsuario) values(UUID_TO_BIN('5f49546e-1814-11f0-ae72-7c70db288abf'), 'natural', 'C.C.', 11234, 'Alejandra', 'Lara', 'Trabajador',UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'), true, 1, 'activo');
insert into Expediente (idExpediente, tituloExp, areaExpediente, descripcion, precio, ciudadExp, creadoPor) values(UUID_TO_BIN('89f6ef27-1814-11f0-ae72-7c70db288abf'), 'Ejecutivo Singular', 'Civil', 'Cobro de una letra de cambio vencida', '1000000', 'Bogotá', UUID_TO_BIN('550e8400-e29b-41d4-a716-446655440000'));
insert into ExpedienteContacto(idExpediente, idContacto, rolContacto) values(UUID_TO_BIN('89f6ef27-1814-11f0-ae72-7c70db288abf'), UUID_TO_BIN('5f49546e-1814-11f0-ae72-7c70db288abf'), 'Demandante');
insert into Documento(idDocumento, nombreDocumento, origenDocumento, enlaceDocumento, creadoPor) values(UUID_TO_BIN('6dcedb30-1a4f-11f0-ae72-7c70db288abf'), 'Demanda', 'Abogado a cargo', 'www.ejemplo.com/documento-prueba-1', UUID_TO_BIN('5f49546e-1814-11f0-ae72-7c70db288abf'));
insert into DocumentoExpediente(idExpediente, idDocumento) values(UUID_TO_BIN('89f6ef27-1814-11f0-ae72-7c70db288abf'), UUID_TO_BIN('6dcedb30-1a4f-11f0-ae72-7c70db288abf'));
insert into Nota (idNota, tituloNota, contenidoNota, creadoPor, tipoNota) values (UUID_TO_BIN('bcd69ca4-1a4f-11f0-ae72-7c70db288abf'), 'Reunión con cliente (tel)', 'Se discute demanda con el cliete y se sugieren cambios, se programó la ultima reunión de revisión para el proximo lunes(tel)', UUID_TO_BIN('5f49546e-1814-11f0-ae72-7c70db288abf'), 'Relacionada');
insert into NotaRelacion(idNota, idExpediente) values (UUID_TO_BIN('bcd69ca4-1a4f-11f0-ae72-7c70db288abf'), UUID_TO_BIN('89f6ef27-1814-11f0-ae72-7c70db288abf'));
insert into Tarea (idTarea, esPrivado, nombreTarea, descripcionTarea, fechaVencimiento, prioridad, creadoPor) values(UUID_TO_BIN('331e657b-1a50-11f0-ae72-7c70db288abf'), false, 'Radicación Documentos', 'Radicar la demanda, agrgar copia del acta de reparto y actualizar datos del juzgado asignado', 20250414, 'Alta', UUID_TO_BIN('5f49546e-1814-11f0-ae72-7c70db288abf'));
insert into TareaRelacion(idTarea, idContacto) values (UUID_TO_BIN('331e657b-1a50-11f0-ae72-7c70db288abf'), UUID_TO_BIN('5f49546e-1814-11f0-ae72-7c70db288abf'));
insert into Evento(idEvento, tituloEvento, descripcionEvento, fechaHoraInicio, fechaHoraFin, allDay, creadoPor) values (UUID_TO_BIN('998b2081-1a50-11f0-ae72-7c70db288abf'), 'Audiencia Inicial', 'Se fija audiencia virtual, se deben confirmar correos al juzgado una semana antes', '2024-04-10 10:00', '2024-04-1 13:00', false, UUID_TO_BIN('5f49546e-1814-11f0-ae72-7c70db288abf'));
insert into EventoRelacion(idEvento, idExpediente) values(UUID_TO_BIN('998b2081-1a50-11f0-ae72-7c70db288abf'), UUID_TO_BIN('89f6ef27-1814-11f0-ae72-7c70db288abf'));
insert into Notificaciones(idNotificacion, idContacto, tipoNotificacion, mensaje, leida) values(UUID_TO_BIN('210e9d98-1a51-11f0-ae72-7c70db288abf'), UUID_TO_BIN('5f49546e-1814-11f0-ae72-7c70db288abf'), 'Recordatorio', 'Próxima audiencia en 10 días', false);



Select BIN_TO_UUID(idContacto) as uuid, nombre, apellido from Contactos;
Select BIN_TO_UUID(idDocumento) as uuid, nombreDocumento from Documento;
Select BIN_TO_UUID(idExpediente) as uuid, tituloExp from Expediente;
Select BIN_TO_UUID(idNota) as uuid, tituloNota, contenidoNota from Nota;
Select BIN_TO_UUID(idTarea) as uuid, nombreTarea, descripcionTarea from Tarea;
Select BIN_TO_UUID(idEvento) as uuid, tituloEvento, descripcionEvento from Evento;
Select BIN_TO_UUID(idNotificacion) as uuid, mensaje from Notificaciones;


select BIN_TO_UUID(ec.idRelacionEC) as idRelacionEC, BIN_TO_UUID(e.idExpediente) AS idExpediente, e.tituloExp as titulo,e.descripcion as descripcion, BIN_TO_UUID(c.idContacto) AS idContacto, c.nombre as nombre, c.apellido as apellido, ec.rolContacto as rol from ExpedienteContacto ec inner join Expediente e on ec.idExpediente = e.idExpediente inner join Contactos c on ec.idContacto = c.idContacto
