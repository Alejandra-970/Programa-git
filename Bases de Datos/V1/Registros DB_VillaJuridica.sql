insert into despacho(nomdespacho,emaildespacho,teldespacho,diredespacho,lugardespacho,especialidad,categoria)
values('Juzgado 62 Pequeñas Causas Competencia Múliple de Bogotá', 'cmpl80bt@cendoj.ramajudicial.gov.co',6013532666,'Carrera 10 No. 19-65, piso 5', 'Bogotá','sin asignar','pequeñas causas'),
('Juzgado 1 Pequeñas Causas laboral de Bogotá', 'j01lpcbta@cendoj.ramajudicial.gov.co',3226701821,'Edificio Camacol, Carrera 10 No. 19-65', 'Bogotá','laboral','pequeñas causas'),
('Juzgado 10 Civil Municipal de Bogotá', 'cmpl10bt@cendoj.ramajudicial.gov.co',6013532666,'Edificio Hernando Morales Molina, Carrera 10 No. 10-33, piso 6', 'Bogotá','civil','municipal'),
('Juzgado 2 Penal Municipal de Bogotá', 'j02pmgbt@cendoj.ramajudicial.gov.co',6015746537,'Edificio Convida, Calle 16 No. 7-39, Piso 7', 'Bogotá','penal','municipal'),
('Juzgado 39 Familia Circuito de Bogotá', 'j39fctobta@cendoj.ramajudicial.gov.co',6013532666,'Edificio Hernando Morales Molina, Carrera 10 No. 10-33', 'Bogotá','familia','circuito'),
('Juzgado 1 Familia Circuito de Bogotá', 'flia01bt@cendoj.ramajudicial.gov.co',6012822094,'Carrera 7 No. 12C-23, Piso 3', 'Bogotá','familia','circuito'),
('Despacho 6 Sala Laboral Tribunal Superior de Bogotá', 'des06sltbta@cendoj.ramajudicial.gov.co',6014233390,'Calle 12 No. 7-65', 'Bogotá','laboral','tribunal'), 
('Despacho 28 Sala penal Tribunal Superior de Bogotá', 'des28sptsbta@cendoj.ramajudicial.gov.co',6014233390,'Calle 12 No. 7-65', 'Bogotá','penal','tribunal'),
('Superintendencia de Industria y Comercio', 'contactenos@sic.gov.co',6015920400,'Av. Carrera 7 No. 31a-36, Piso 3', 'Bogotá','civil','superintendencia'),
('sin despacho', 'N/A',0,'N/A', 'N/A','sin asignar','otro'),
('Comision Seccional de Disciplina Judicial de Bogotá', 'discbogota@cendoj.ramajudicial.gov.co',6016214093,'Calle 85 No 11-96, Piso 7 ', 'Bogotá','sin asignar','otro');
select * from despacho;

insert into trabajador(nomtrabajador,emailtrabajador,teltrabajador,lugartrabajador)
values('Maria Juana Barrios','MariaB@villajuridica.com','3141021436','Bogotá'),
('Francisco Luis Sales','FranciscoS@villajuridica.com','3051164057','Bogotá'),
('Marco Abellan','MarcoA@villajuridica.com','3134555111','Bogotá'),
('Myriam Rivas','MyriamR@villajuridica.com','3164096822','Bogotá'),
('Alexandra Ferreiro','AlexandraF@villajuridica.com','3223730133','Bogotá'),
('Consuelo Franco','ConsueloF@villajuridica.com','3144632617','Bogotá'),
('Cecilia Jaramillo','CeciliaJ@villajuridica.com','3144632615','Bogotá'),
('Maria Victoria Saez','MariaS@villajuridica.com','3200232226','Bogotá'),
('Maria Ines Bottella','MariaB@villajuridica.com','3164587404','Bogotá'),
('Claudia Borras','ClaudiaB@villajuridica.com','3008033567','Bogotá');
select * from trabajador;

insert into contacto(idcontacto,nomcontacto,emailcontacto,telcontacto,direcontacto,lugarcontacto,tipocontacto)
values('4414169','Ruth Leal','ruth4521@outlook.com','3166758343','Carrera 48 No.16-06','Bogotá','Potencial'),
('9859830','Leyre Bonilla','lebonilla@yahoo.com','3142288538','Av 2 No.9-09','Bogotá','Cliente'),
('10258284','Barbara Fernandez','barbiefer.1025@hotmail.com','3189235801','Calle 44 No. 3-44','Bogotá','Cliente'),
('10283450','Jose Gabriel Buendia','buendia.jose@gmail.com','3195216635','Carrera 2 No. 8-31, Edificio Santa Maria','Bogotá','Potencial'),
('16071773','Maria Rosario Mejia','mari_mejia45841@hotmail.com','3180620976','Calle 11 No. 43-50','Bogotá','Inactivo'),
('16072419','Omar Alfonso','omaralfonso123@gmail.com','3125636806','Carrera 19A No. 103A-21','Bogotá','Inactivo'),
('16074108','Octavio Palma','octavio-palma@yahoo.com','3177806790','Calle 55 No. 35-54','Bogotá','Potencial'),
('16075877','Roberto Carlos Marin','marinrobertocarlos@gmail.com','3168222200','Carrera 23 No. 122-59','Bogotá','Sin contratar'),
('16077704','Roberto Barrios','robe-barrios74@outlook.com','3106015649','Calle 21A No. 75-84','Bogotá','Sin contratar'),
('16078105','Maria Angeles Pazos','mariangelespazos@hotmail.com','3184788303','Calle 13 No. 18-07 Edificio San Francisco','Bogotá','Cliente');
select * from contacto;

insert into expediente(area,tipoexpediente,nomcontraparte,nomabogadocon,emailabogadocon,ciudadexpediente,nomdespacho,idtrabajador)
values('penal','litigio-audiencias','Fidel Bustamante','Pedro Jimenez','pedrojimenezabogado@gmail.com','Bogotá','Juzgado 2 Penal Municipal de Bogotá',1),
('laboral','litigio-audiencias','Purificación Martinez','Raul Borras','raulbabogado@gmail.com','Bogotá','Juzgado 1 Pequeñas Causas laboral de Bogotá',2),
('familia','litigio-audiencias','Daniela Ibarra','Daniel Patiño','abogadopatiño_daniel@gmail.com','Bogotá','Juzgado 1 Familia Circuito de Bogotá',3);

insert into expediente(area,tipoexpediente,nomcontraparte,emailcontraparte,ciudadexpediente,idtrabajador,nomdespacho)
values('civil','extraprocesal','Fidel Bustamante','pedrojimenezabogado@gmail.com','Medellin',4,'sin despacho'),
('civil','extraprocesal','Purificación Martinez','raulbabogado@gmail.com','Zipaquira',5,'sin despacho'),
('civil','extraprocesal','Purificación Martinez','raulbabogado@gmail.com','Cartagena',6,'sin despacho'),
('civil','extraprocesal','Daniela Ibarra','abogadopatiño_daniel@gmail.com','Ibague',7,'sin despacho');

insert into expediente(area,tipoexpediente,nomcontraparte,emailcontraparte,ciudadexpediente,nomdespacho,idtrabajador)
values('civil','litigio-demanda radicada','Antonio Francisco Costa','Anotnio-Costa123@gmail.com','Bogotá','Superintendencia de Industria y Comercio',8),
('civil','litigio-demanda radicada','Maria Piedad Silva','mariasilva.852@hotmail.com','Bogotá','Superintendencia de Industria y Comercio',9),
('civil','litigio-demanda radicada','Vicente Jose Garzon','vicente-jose145@yahoo.com','Bogotá','Superintendencia de Industria y Comercio',10);
select * from expediente;

insert into expediente_contacto(idcontacto,idexpediente)
values(4414169,1);

insert into expediente_contacto(idcontacto,idexpediente)
values(9859830,1),(10258284,2);

insert into expediente_contacto(idcontacto,idexpediente)
values(16071773,3),(16072419,4),(16074108,5),(16074108,6),(16074108,7),(16075877,8),(16077704,9),(16078105,10);
select * from expediente_contacto

