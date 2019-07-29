package com.example.examen1b

class User (var name: String){
    companion object {
        lateinit var currentUser: User
        private var adapter: UserHttpAdapter = UserHttpAdapter()

        fun logIn(name: String) : User? {
            var user = adapter.execute(name).get()
            return user
        }
    }
}