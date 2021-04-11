package com.ogre.eva


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity

import android.widget.*

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.ogre.eva.fragment.post


class HomeAcivity: AppCompatActivity() {

    private lateinit var drawerlayout: DrawerLayout
    private var mAuth: FirebaseAuth? = null

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        mAuth = FirebaseAuth.getInstance();

        val marketfragment = marketplace()
        val homefragment = home()
        val followframent = follow()
        val messagefrag = mesages()
        val notiffrag = notification()
        val postfrag = post()
        val bottom = findViewById<BottomNavigationView>(R.id.nav2)
        bottom.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> makecur(homefragment)
                R.id.message ->makecur(messagefrag)
                R.id.Follow -> makecur(followframent)
                R.id.Notification -> makecur(notiffrag)
                R.id.Post -> makecur(postfrag)
            };true
        }

        val search = findViewById<Button>(R.id.searchbutton)
        search.setOnClickListener {
            val intent = Intent(this, searchActivity::class.java)
            startActivity(intent)
        }



        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerlayout = findViewById(R.id.drawer)
        var navview: NavigationView = findViewById(R.id.nav)
        navview.bringToFront()
        val toggle = ActionBarDrawerToggle(this, drawerlayout, 0, 0)
        toggle.isDrawerIndicatorEnabled = true
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setIcon(R.drawable.hambuerger)

        toolbar.setOnClickListener{
            drawerlayout.openDrawer(Gravity.START, true)

        }




        val market = findViewById<ImageButton>(R.id.marketplace)

        market.setOnClickListener{ v ->
            makecur(marketfragment)

        }




        navview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Profile -> {
                    val intent2 = Intent(this, profile::class.java)
                    startActivity(intent2)
                }
                R.id.Logout -> {
                    mAuth!!.signOut()
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)



                }
                R.id.Settings -> Toast.makeText(this,"Settings", Toast.LENGTH_SHORT).show()
            };true
        }

        makecur(homefragment)


    }


 @SuppressLint("WrongConstant")

 override fun onBackPressed() {
     if (drawerlayout.isDrawerOpen(Gravity.START)) {
         drawerlayout.closeDrawer(Gravity.LEFT)
     } else
         super.onBackPressed()
 }

    private fun makecur(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.replacement, fragment)
            commit()
        }




}