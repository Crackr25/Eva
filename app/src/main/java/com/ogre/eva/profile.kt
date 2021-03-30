package com.ogre.eva


import android.content.Intent
import android.os.Bundle

import android.widget.*

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.ogre.eva.follow
import com.ogre.eva.notification
import com.ogre.eva.fragment.post


class profile: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val homefragment = grid()
        val followframent = scroll()


        val grid = findViewById<Button>(R.id.gridview)
        val scroll = findViewById<Button>(R.id.horizontalScrollView)

        grid.setOnClickListener {
             v ->

            makecur(homefragment)

        }
        scroll.setOnClickListener{
            v ->
            makecur(followframent)

        }


        makecur(homefragment)


    }

    private fun makecur(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.replacement2, fragment)
            commit()
        }


}