package com.example.firstkotlinapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var users: List<Users> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = users.size

    fun submitList(mUser: List<Users>) {
        users = mUser
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var UserName = view.name
        var UserPhone = view.phoneNumber
        var UserAge = view.age
        var UserGender = view.gender

        fun bind(User: Users) {
            UserName.setText(User.name)
            UserPhone.setText(User.PhoneNumber)
            UserAge.setText(User.age)
            UserGender.setText(User.gender)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var musers: Users = users[position]
        when
            (holder) {
            is ViewHolder -> {
                holder.bind(musers)
                holder.itemView.setOnClickListener(View.OnClickListener {
                    val intent = Intent(holder.itemView.context, Profile::class.java)
                    intent.putExtra("gender",musers.gender)
                    intent.putExtra("age",musers.age)
                    intent.putExtra("name",musers.name)
                    intent.putExtra("phoneNumber",musers.PhoneNumber)
                    holder.itemView.context.startActivity(intent)
                })
            }
        }


    }


}


