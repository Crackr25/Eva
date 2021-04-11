package com.ogre.eva


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot


class profile: AppCompatActivity() {


    var db = FirebaseFirestore.getInstance()

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val homefragment = grid()
        val followframent = scroll()


        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setTitle("Profile")
       /* toolbar.setOnClickListener{
          val intent = Intent(this, HomeAcivity::class.java)
          startActivity(intent)
      }*/
        db.collection("users")
            .get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                      val text = document.getString("Username")
                        Log.d(
                            "user",
                            document.id + " => " + document.data


                        )
                        val user: TextView = findViewById(R.id.Username)
                        user.setText(text)

                    }
                } else {
                    Log.w("wow", "Error getting documents.", task.exception)
                }
            })







        toolbar.setNavigationOnClickListener{
            val intent = Intent(this, HomeAcivity::class.java)
            startActivity(intent)
        }


        val grid = findViewById<Button>(R.id.gridview)
        val scroll = findViewById<Button>(R.id.horizontalScrollView)
        grid.setTextColor(Color.BLUE)
        grid.setOnClickListener {
             v ->
            grid.setTextColor(Color.BLUE)
            scroll.setTextColor(Color.BLACK)
            makecur(homefragment)

        }
        scroll.setOnClickListener{
            v ->
            makecur(followframent)
            scroll.setTextColor(Color.BLUE)
            grid.setTextColor(Color.BLACK)

        }


        makecur(homefragment)


    }

    private fun makecur(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.replacement2, fragment)
            commit()
        }


}