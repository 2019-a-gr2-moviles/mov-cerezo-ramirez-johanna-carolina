/**
 * Movie.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    name:{
      type: 'string',
      minLength: 3,
      maxLength: 60,
    },
    year: {
      type: 'string',
      minLength: 4,
    },
    price: {
      type: 'string',
      minLength: 3,
    },
    gender: {
      type: 'string',
      minLength: 3
    },
    sinopsis: {
      type: 'string',
      minLength: 10
    },
    duration: {
      type: 'string',
      minLength: 3
    },
    image: {
      type: 'string'
    },
    wasPurchased: {
      type: 'boolean'
    },
    bePurchased:{
      collection: 'purchase',
      via: 'fkMovie'
    }
  },

};

