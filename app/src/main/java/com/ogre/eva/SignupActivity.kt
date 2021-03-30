package com.ogre.eva

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignupActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val sign_up_activity = findViewById<TextView>(R.id.Log_in)
        sign_up_activity.setOnClickListener{ v ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}