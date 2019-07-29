package com.example.examen1b

class User (var name: String){
    companion object {
        var currentUser = User("")
        var adapter: UserHttpAdapter = UserHttpAdapter()

        fun logIn(name:String){
            currentUser.name = name
            adapter.registerNewUser(name)
        }
    }
}