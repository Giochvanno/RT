package com.itproger.darova

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity2::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if(login == "" || email == "" || pass == "")
                Toast.makeText(this, "There are empty fields!", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "User $login added", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()

                if(login == "" || email == "" || pass == "")
                    Toast.makeText(this, "There are empty fields!", Toast.LENGTH_LONG).show()
            }
        }
    }
}














































































































// val listView = findViewById<ListView>(R.id.listView)
//        val userData: EditText = findViewById(R.id.user_data)
//        val button: Button = findViewById(R.id.button)
//
//        val todos: MutableList<String> = mutableListOf()
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
//        listView.adapter = adapter
//
//        listView.setOnItemClickListener { parent, view, position, id ->
//            val text = listView.getItemAtPosition(position).toString()
//            adapter.remove(text)
//
//            Toast.makeText(this, "Мы удалили: $text", Toast.LENGTH_LONG).show()
//        }
//
//
//        button.setOnClickListener {
//            val text = userData.text.toString().trim()
//            if (text != "")
//                adapter.insert(text, 0)








//<?xml version="1.0" encoding="utf-8"?>
//<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:app="http://schemas.android.com/apk/res-auto"
//xmlns:tools="http://schemas.android.com/tools"
//android:id="@+id/main"
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//tools:context=".MainActivity">
//
//<TextView
//android:id="@+id/main_label"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:text="Список дел"
//android:textSize="20sp"
//android:textStyle="bold"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="parent"
//app:layout_constraintVertical_bias="0.136" />
//
//<EditText
//android:id="@+id/user_data"
//android:layout_width="wrap_content"
//android:layout_height="50dp"
//android:layout_marginTop="36dp"
//android:ems="10"
//android:hint="Введите текст"
//android:inputType="text"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintHorizontal_bias="0.497"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@+id/main_label" />
//
//<Button
//android:id="@+id/button"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginTop="28dp"
//android:text="Добавить"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@+id/user_data" />
//
//<ListView
//android:id="@+id/listView"
//android:layout_width="wrap_content"
//android:layout_height="400dp"
//android:layout_marginStart="20dp"
//android:layout_marginTop="20dp"
//android:layout_marginEnd="20dp"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toBottomOf="@+id/button" />
//
//</androidx.constraintlayout.widget.ConstraintLayout>