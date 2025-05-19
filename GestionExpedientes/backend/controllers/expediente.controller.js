/**
 * Se coloca el controlador como un objeto y luego se exporta como
 * se requiere primero el modelo Expediente
 */

 const Expediente = require('../models/expediente');
 const expedienteCtrl = {};
 
 /**
  * DEFINO LOS METODOS  */
 
 //Obtener todos los Expedientes
 expedienteCtrl.getExpedientes = async (req, res) => {
     const expediente = await Expediente.find();
     res.json(expediente);   
}                    
 
 // Crear Expedientes
 
 expedienteCtrl.createExpedientes = async (req, res) => {
    // Copiar todos los datos excepto openingDate
    const data = {
        ...req.body,
        openingDate: new Date() 
    };
    const expediente = new Expediente(data);
    await expediente.save();
    res.json({ status: 'Expediente guardado' });
};

 //Conseguir un Unico Expediente
 expedienteCtrl.getUnicoExpediente = async (req, res) => {     
     const expedienteUnico = await Expediente.findById(req.params.id); 
     res.json(expedienteUnico);
 }
 
 //Actualizar Expediente
 expedienteCtrl.editarExpediente = async (req, res) =>  {
     const { id } = req.params; 
     const expedienteEdit = {  
        title: req.body.title,
        area: req.body.area,
        description: req.body.description,
        openingDate: req.body.openingDate,
        closingDate: req.body.closingDate,
        price: req.body.price,
        docketNumber: req.body.docketNumber,
        docketDate: req.body.docketDate,
        city: req.body.city,
        status: req.body.status,
        kanbanStage: req.body.kanbanStage
     };
     await Expediente.findByIdAndUpdate(id, {$set: expedienteEdit}, {new:  true}); 
     res.json({status: 'Expediente Actualizado'});
 }

 // Eliminar Expediente 
 expedienteCtrl.eliminarExpediente = async (req, res) => {
     await Expediente.findByIdAndDelete(req.params.id);
     res.json({status: 'Expediente Eliminado'});
 }
  
 //exporto el modulo
 module.exports = expedienteCtrl;