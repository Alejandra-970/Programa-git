const express = require('express')
const morgan = require('morgan');
const cors = require('cors');
const app = express(); // la constante app tendra ahora todo el funcionamiento del servidor
const { mongoose } = require('./database'); // no se quiere todo el archivo sino la conexion
/** * Se crea una REST API, es la manera de decirle al servidor que reciba y envie datos  */
// Configuraciones
app.set('port', process.env.PORT || 3000);
app.use(morgan('dev')); 
app.use(express.json()); // metodo que ayuda a convertir el codigo para que el servidor pueda entender lo que viene del cliente.
app.use(cors({origin: 'http://localhost:4200'})); // metodo para comunicar con el cliente
// rutas de nuestro servidor
app.use('/api/expedientes',require('./routes/expediente.route'));
// Iniciando el servidor
app.listen(app.get('port'), () => {// esta es una mejor manera de configurar el puerto
    console.log('server activo en el puerto', app.get('port'));
}); 
