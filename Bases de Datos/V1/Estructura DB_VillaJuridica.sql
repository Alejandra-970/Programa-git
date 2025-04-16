create database villajuridica;
drop database villajuridica;
use villajuridica;

create table contacto(
idcontacto int not null primary KEY,
persona enum('natural', 'juridica', 'sin asignar') default 'sin asignar',
nomcontacto varchar(255) not null,
emailcontacto varchar(255) not null,
telcontacto varchar(20),
direcontacto varchar(255),
lugarcontacto varchar(255) not null,
tipocontacto enum('Sin asignar', 'Potencial', 'Cliente', 'Sin contratar', 'Inactivo') default 'sin asignar'
);
describe contacto;

create table trabajador(
idtrabajador int auto_increment primary	key,
nomtrabajador varchar(255) not null,
emailtrabajador varchar(255) not null,
teltrabajador varchar(20),
chatid varchar(255),
lugartrabajador varchar(255) not null,
tipotrabajador enum('Sin asignar', 'Secretaria', 'Abogado Senior', 'Abogado Junior', 'Judicante') default 'sin asignar',
estatustrabajador enum('Activo', 'Inactivo', 'Vacaciones', 'Incapacidad') default 'Activo'
);
describe trabajador;

create table despacho(
nomdespacho varchar(255) not null primary key,
emaildespacho varchar(255) not null,
teldespacho varchar(20) not null,
diredespacho varchar(255) not null,
lugardespacho varchar(255) not null,
especialidad enum('sin asignar', 'civil', 'penal', 'familia', 'administrativo', 'laboral','disciplinario','otro') default 'sin asignar',
categoria enum('sin asignar', 'pequeñas causas', 'municipal', 'circuito', 'tribunal', 'corte', 'descongestion', 'superintendencia', 'casa de justicia', 'centro de conciliacion', 'arbitraje', 'otro') default 'sin asignar'
);
describe despacho;

create table expediente(
idexpediente int auto_increment primary	key,
fecha_creacion timestamp default current_timestamp,
area enum('sin asignar', 'civil', 'penal', 'familia', 'administrativo', 'laboral','disciplinario','otro') default 'sin asignar',
tipoexpediente enum('extraprocesal', 'pre-litigio', 'litigio-demanda radicada', 'litigio-traslado', 'litigio-audiencias', 'litigio-ejecucion fallo', 'litigio-recurso') default 'extraprocesal',
nomcontraparte varchar(255),
emailcontraparte varchar(255),
telcontraparte varchar(20),
nomabogadocon varchar(255),
emailabogadocon varchar(255),
telabogadocon varchar(20),
numradicado int,
ciudadexpediente varchar(255) not null,
fecharadicado date
);
describe expediente;

alter table expediente 
add nomdespacho varchar(255) not null;

describe expediente; 
  
alter table expediente
add constraint fk_expedespacho
foreign key(nomdespacho)
references despacho(nomdespacho)
on delete cascade
on update cascade;

alter table expediente 
add idtrabajador int;

alter table expediente
add constraint fk_expetrabajador
foreign key(idtrabajador)
references trabajador(idtrabajador)
on delete cascade
on update cascade;

create table expediente_contacto(
idcontacto int not null,
idexpediente int
);
describe expediente_contacto;

alter table expediente_contacto
add constraint fk_contacto_expediente 
foreign key(idcontacto)
references contacto(idcontacto)
on delete cascade
on update cascade;

alter table expediente_contacto
add constraint fk_expediente_contacto 
foreign key(idexpediente)
references expediente(idexpediente)
on delete cascade
on update cascade;
 