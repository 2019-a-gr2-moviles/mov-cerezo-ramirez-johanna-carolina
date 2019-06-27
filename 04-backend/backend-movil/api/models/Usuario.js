/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 60,
    },
    cedula: {
      type: 'string',
      required: true,
      unique: true,
      minLength: 10,
      maxLength: 25
    },
    username: {
      type: 'string',
      required: true,
      unique: true
    },
    fechaDeNacimiento: {
      type: 'string'
    },
    sueldo:{
      type: 'number',
      min: 100,
      max: 5000,
      defaultsTo:100.00
    },
    estaCasado:{
      type: 'boolean'
    },
    longitudCasa: {
      type: 'string'
    },
    latitudCasa: {
      type: 'string'
    },
    tipoUsaurio:{
      type:'string',
      enum: ['normal','pendiente','premium']
    },
    tipoUsaurio:{
      type:'string',
      isEmail: true
    },
     //Configuracion del hijo
     fkEmpresa:{ //Nombre del FKpara la relacion
      model: 'empresa' //Nombre del modelo a relacionar (padre)
    },
      //Configuracion del papa
  serviciosDeUsuario:{ //Nombre atributo de la relacion
    collection:'servicio', //Nombre del modelo a realcionar
    via: 'fkUsuario' //Nombre del atributo  FK del otro modelo
  }
    
  },


};

