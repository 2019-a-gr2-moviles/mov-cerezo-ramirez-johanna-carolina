/**
 * Driver.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    name:{
      type: 'string',
      minLength: 3,
      maxLength: 60
    },
    lastname:{
      type: 'string',
      minLength: 3,
      maxLength: 60
    },
    birthDate:{
      type: 'string'
    },
    license:{
      type: 'boolean'  
    },
    carsNumber:{
      type: 'number'
    },
    hasCars:{
      collection:'car',
      via:'fkDriver'
    } 

  },

};

