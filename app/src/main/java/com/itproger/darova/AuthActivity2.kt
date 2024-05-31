package com.itproger.darova

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AuthActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_auth2)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)


        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        linkToReg.setOnClickListener {
            val intent = Intent(this, AuthActivity2::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()

            val pass = userPass.text.toString().trim()

            if(login == "" || pass == "")
                Toast.makeText(this, "There are empty fields!", Toast.LENGTH_LONG).show()
            else {

                val db = DbHelper(this, null)
                val user_id = db.getUser(login, pass)
                Toast.makeText(this, "User ID: $user_id", Toast.LENGTH_LONG).show()

                if (user_id != null) {
                    Toast.makeText(this, "User $login added", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()

                    userPass.text.clear()


                    val intent = Intent(this, ItemsActivity::class.java)
                    val b = Bundle()
                    b.putInt("user_id", user_id)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "Wrong login or password", Toast.LENGTH_LONG).show()



            }
        }
        }
    }
