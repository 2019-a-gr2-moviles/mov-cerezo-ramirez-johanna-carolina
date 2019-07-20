/**
 * Purchase.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    datePurchase:{
      type: 'string',
    },
    price: {
      type: 'string',
    },
    fkUser:{
      model: 'user'
    },
    fkMovie:{
      model: 'movie'
    }

    
  },

};

