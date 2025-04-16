select * from expediente
where area='civil'
order by nomcontraparte asc;

select * from contacto
where tipocontacto='potencial'
order by nomcontacto desc;

select * from expediente
where area='civil' and tipoexpediente='extraprocesal'
order by ciudadexpediente asc;

delete from expediente where idexpediente=1;
select *from expediente;
select *from contacto;

select expediente.idexpediente, trabajador.idtrabajador, trabajador.nomtrabajador
from expediente
inner join trabajador
on trabajador.idtrabajador=expediente.idtrabajador;

select expediente_contacto.idexpediente, expediente_contacto.idcontacto, contacto.nomcontacto
from expediente_contacto
inner join contacto
on expediente_contacto.idcontacto=contacto.idcontacto
