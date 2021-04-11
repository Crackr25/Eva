package com.ogre.eva
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {


    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editmail: EditText = findViewById(R.id.EmailAddress)
        val editpass: EditText = findViewById(R.id.Password)

        mAuth = FirebaseAuth.getInstance();
// ...
// Initialize Firebase Auth


        val sign_up_activity = findViewById<TextView>(R.id.sign_up)
        sign_up_activity.setOnClickListener { v ->
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        val log_in = findViewById<Button>(R.id.logIn_btn)
        log_in.setOnClickListener { v ->
            val email = editmail.text.toString().trim()
            val pass = editpass.text.toString().trim()

            if (email.isEmpty()) {
                editmail.setError("Email Required")
                editmail.requestFocus()
            }
            if (pass.isEmpty()) {
                editpass.setError("Password Required")
                editpass.requestFocus()
            }
            if (pass.isNotEmpty() && email.isNotEmpty()) {
                mAuth!!.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, HomeAcivity::class.java)
                            startActivity(intent)
                        }else {
                            Toast.makeText(
                                this, "Log in failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }

            }
        }


    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth!!.currentUser
        if (currentUser != null) {
            val intent = Intent(this, HomeAcivity::class.java)
            startActivity(intent)
        }


    }




    }
