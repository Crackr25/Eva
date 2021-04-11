package com.ogre.eva


import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class searchActivity: AppCompatActivity(), SearchView.OnQueryTextListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search)


        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setTitle("Message")

        toolbar.setNavigationOnClickListener {
            val intent = Intent(this, HomeAcivity::class.java)
            startActivity(intent)
        }
        //    initRecyclerView()
        val searchview = findViewById<SearchView>(R.id.searchbox)
//
        searchview.setOnQueryTextListener(this)

 /*       searchvi   ew.setOnSearchClickListener{
            initRecyclerView()
        }*/



    }

    interface SearchViewQueryTextCallback{
        fun onQueryTextSubmit(query: String?)
    }

/*    private fun SearchView.setQueryTextSubmit(callback: SearchViewQueryTextCallback) {
        setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                callback.onQueryTextSubmit(query)

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                initRecyclerView()
                return false
            }
        })
    }*/





    private fun initRecyclerView() {
        //   val userlist = generateUser(20)
        val search = findViewById<RecyclerView>(R.id.result)
        search.layoutManager = LinearLayoutManager(this)
        search.adapter = searchAdapter()
        search.setHasFixedSize(true)

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        initRecyclerView()

        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

/*    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("Not yet implemented")
    }*/
}


 /*   private fun generateUser(size: Int): List<messageItem> {

        val list = ArrayList<messageItem>()
        for (i in 0 until size) {
            val drawable = R.drawable.gwapo
            val name = when(i % 3){
                0 -> "Izakahr"
                else -> "Kakar"
            }

            val item = messageItem(drawable, name , "Hi")
            list += item
        }
        return list
    }
}*/
