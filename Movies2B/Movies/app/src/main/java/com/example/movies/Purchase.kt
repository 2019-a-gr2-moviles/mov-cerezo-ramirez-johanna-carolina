package com.example.movies

import android.util.Log

class Purchase(
    var id:Int,
    var datePurchase: String,
    var price: String,
    var fkMovie: Int,
    var fkUser: Int
){
    companion object {
        var purchases = listOf<Purchase>()
        private var adapter: PurchaseHttpAdapter = PurchaseHttpAdapter()

        fun refreshList() {
            if (adapter.getAll() != null) {
                purchases = adapter.getAll()!!
                Log.i("load:", "purchases loaded")
            }

        }
    }
}