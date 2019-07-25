/**
 * PurchaseController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
  
    myMovies : async (req, res) => {
        try{
            var movie = await Purchase.find({fkUser : req.param('id')}).populate('fkMovie')
            var productsList = []
            Object.entries(movie).forEach(element => { 
                productsList.push(element[1].fkMovie)
            })
            console.log(productsList)
            return res.ok(productsList)
        }catch(e){
            return res.serverError()
        }
    }



};

