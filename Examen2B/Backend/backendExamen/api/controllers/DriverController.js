/**
 * DriverController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
  
    driverCars : async (req, res) => {
        try{
            var car = await Purchase.find({fkDriver : req.param('id')})
            var carList = []
            Object.entries(car).forEach(element => { 
                carList.push(element[1].fkDriver)
            })
            console.log(carList)
            return res.ok(carList)
        }catch(e){
            return res.serverError()
        }
    }

};

