const mongoose = require('mongoose'); 
 const URI = 'mongodb+srv://root:TqsRkickq2IxJQ1Z@cluster0.6njp3nv.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0'; 
 mongoose.connect(URI)
     .then(db => console.log('DB is connected'))
     .catch(err => console.error(err));  
 module.exports = mongoose; 