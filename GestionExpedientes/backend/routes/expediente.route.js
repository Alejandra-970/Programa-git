/**
*
* creamos un módulo por eso utilizamos express
*/

const express = require('express');
const router = express.Router();
const expedienteCtrl = require('../controllers/expediente.controller');

router.get('/', expedienteCtrl.getExpedientes); // Rutas más limpias (obtener expediente)

router.post('/', expedienteCtrl.createExpedientes);//guardar

router.get('/:id', expedienteCtrl.getUnicoExpediente);// obtiene un único expediente

router.put('/:id',expedienteCtrl.editarExpediente); //Actualizar datos (uno a la vez)

router.delete('/:id', expedienteCtrl.eliminarExpediente);

module.exports = router; 
