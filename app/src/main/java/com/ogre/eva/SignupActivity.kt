package com.ogre.eva

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class SignupActivity: AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)
        val edituser: EditText = findViewById(R.id.Usernamemain)
        val editnum: EditText = findViewById(R.id.number)
        val editmail: EditText = findViewById(R.id.emailadd)
        val editpass: EditText = findViewById(R.id.pass)
        val editpass2: EditText = findViewById(R.id.pass1)


        mAuth = FirebaseAuth.getInstance();


        val sign_up_activity = findViewById<TextView>(R.id.Log_in)
        sign_up_activity.setOnClickListener { v ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val register: Button = findViewById(R.id.button2)
        register.setOnClickListener { v ->
            val name = edituser.text.toString().trim()
            val num = editnum.text.toString().trim()
            val email = editmail.text.toString().trim()
            val pass = editpass.text.toString().trim()
            val pass2 = editpass2.text.toString().trim()
            var a: Boolean = false

            if (name.isEmpty()) {
                edituser.setError("Username Required")
                edituser.requestFocus()
            }

            if (num.length < 11) {
                editnum.setError("Enter a valid number")
                editnum.requestFocus()
            }

            if (email.isEmpty()) {
                editmail.setError("Email Required")
                editmail.requestFocus()
            }
            if (pass.isEmpty()) {
                editpass.setError("Password Required")
                editpass2.requestFocus()
            }
            if (pass2.isEmpty()) {
                editpass2.setError("Password Required")
                editpass2.requestFocus()
            }
            if (pass2 != pass) {
                Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show()
                editpass2.setText("")
                editpass2.setError("Enter Password")
                editpass2.requestFocus()

            } else {
                if (pass.length > 0) {
                    a = true
                }
            }
            if (a == true) {
                mAuth!!.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val useritem: MutableMap<String, Any> =
                                HashMap()
                            useritem["Username"] = name
                            useritem["Phone"] = num

                            db.collection("users")
                                .add(useritem)
                                .addOnSuccessListener { documentReference ->
                                    Log.d(
                                        "Success",
                                        "DocumentSnapshot added with ID: " + documentReference.id
                                    )
                                }
                                .addOnFailureListener { e ->
                                    Log.w(
                                        "Failed", "Error adding document",
                                        e
                                    )
                                }

                            Toast.makeText(this, "Authentication Successful.", Toast.LENGTH_SHORT)
                                .show()
                            val user = mAuth!!.currentUser

                        } else {
                            Toast.makeText(
                                this, "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        // ...
                    }
            }

        }


    }
}
/*

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth!!.currentUser
        if(currentUser !=null){
        val intent = Intent(this, HomeAcivity::class.java)
        startActivity(intent)
    }



}*/
