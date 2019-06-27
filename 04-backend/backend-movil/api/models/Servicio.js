/**
 * Servicio.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type: 'string'
    },
    //Configuracion del hijo
    fkUsuario:{ //Nombre del FKpara la relacion
      model: 'usuario' //Nombre del modelo a relacionar (padre)
    }
  },

};

