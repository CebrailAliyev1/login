package com.example.loginapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginapi.databinding.ActivityMainBinding
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val username  = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            checkUser(username,password)


        }


    }

    fun checkUser(username: String, password: String) {
        val responseCall =
            RetrofitClient().getRetrofitInstance()!!.getApi()!!.checkUser(username, password)
        responseCall.enqueue(object : retrofit2.Callback<Student>{
            override fun onResponse(call: retrofit2.Call<Student>, response: Response<Student>) {
                Toast.makeText(applicationContext,"success",Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: retrofit2.Call<Student>, t: Throwable) {
                Toast.makeText(applicationContext,"an has occured",Toast.LENGTH_SHORT).show()
            }

        })
    }

}

