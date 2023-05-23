package com.example.loginapi


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
   @GET("configStudents.php")
    fun checkUser(@Query("username")username:String,@Query("password")password:String): Call<Student>
}