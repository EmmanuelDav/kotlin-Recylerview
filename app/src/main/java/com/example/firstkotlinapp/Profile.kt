package com.example.firstkotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.firstkotlinapp.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.users = getValue()

    }

    fun getValue(): Users {
        var name = intent.getStringExtra("name")
        var age = intent.getStringExtra("age")
        var phoneNum = intent.getStringExtra("phoneNumber")
        var sex = intent.extras?.getString("gender")
        return Users(name, phoneNum, age, sex.toString())
    }
}