package com.ogre.eva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sign_up_activity = findViewById<TextView>(R.id.sign_up)
        sign_up_activity.setOnClickListener{ v ->
           val intent = Intent(this, SignupActivity::class.java)
           startActivity(intent)
       }
        val log_in = findViewById<Button>(R.id.logIn_btn)
        log_in.setOnClickListener{ v ->
            val intent = Intent(this, HomeAcivity::class.java)
            startActivity(intent)

        }

    }







    }
