const mongoose = require('mongoose');
const {Schema} = mongoose;

const ExpedienteSchema = new Schema({
    title: {type: String, required: true},
    area: {type: String, required: true},
    description: {type: String, required: true},
    openingDate: {type: Date, default: Date.now}, // valor automático
    closingDate: {type: Date },
    price: {type: Number, required: true},
    docketNumber: {type: String},
    docketDate: {type: Date},
    city: {type: String},
    status: {type: String, required: true},
    kanbanStage: {type: String, required: true} 
});

module.exports = mongoose.model('Expediente', ExpedienteSchema);
