package com.example.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var actionAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            actionAdapter = RecyclerAdapter()
           Recyclerview.adapter = actionAdapter

        }
        setData()

    }

    fun setData() {
        var data = addDemoData()
        actionAdapter.submitList(data)
    }


    fun addDemoData(): ArrayList<Users> {
        val users = ArrayList<Users>()
        users.add(
            Users(
                "Emmanuel David",
                "000000000",
                "18",
                "male"
            )

        )
        users.add(
            Users(
                "Abraham",
                "090909090909",
                "26",
                "male"
            )
        )
        return users
    }

}