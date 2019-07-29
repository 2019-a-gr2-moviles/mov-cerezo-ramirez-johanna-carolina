/**
 * Car.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    chassis:{
      type: 'number'
    },
    brandName:{
      type: 'string'
    },
    colorOne:{
      type: 'string'
    },
    colorTwo:{
      type: 'string'
    },
    modelName:{
      type: 'string'
    },
    year:{
      type: 'number'
    },
    long:{
      type: 'string'
    },
    lat:{
      type: 'string'
    },
    fkDriver:{
      model: 'driver'
    }
  },

};

