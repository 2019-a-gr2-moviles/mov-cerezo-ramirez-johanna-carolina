/**
 * Empresa.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type: 'string'
    },
     //Configuracion del papa
  usuariosDeEmpresa:{ //Nombre atributo de la relacion
    collection:'usuario', //Nombre del modelo a realcionar
    via: 'fkEmpresa' //Nombre del atributo  FK del otro modelo
  }
    

  },

};

