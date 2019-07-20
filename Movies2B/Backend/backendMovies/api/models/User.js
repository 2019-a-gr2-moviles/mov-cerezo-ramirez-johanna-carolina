/**
 * User.js
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
    lastname: {
      type: 'string',
      minLength: 3,
      maxLength: 60
    },
    email: {
      type: 'string',
      required: true,
      unique: true,
      isEmail: true
    },
    password: {
      type: 'string',
      required: true,
      minLength: 3
    },
    purchaseMovie:{
      collection: 'purchase',
      via: 'fkUser'
    }

  },

};

