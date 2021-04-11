package com.ogre.eva


import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MessageAcitvity: AppCompatActivity(), messageAdapter.OnItemClickListener {

    private var messadapter: RecyclerView.Adapter<messageAdapter.messageViewHolder>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mesages)
        initRecyclerView()

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setTitle("Message")
        toolbar.setNavigationOnClickListener{
            val intent = Intent(this, HomeAcivity::class.java)
            startActivity(intent)
        }



    }

    private fun initRecyclerView() {
        val userlist = generateUser(20)
        val messageview = findViewById<RecyclerView>(R.id.messageview)
        messageview.layoutManager = LinearLayoutManager(this)
        messageview.adapter = messageAdapter(userlist, this)
        messageview.setHasFixedSize(true)

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"yeah $position", Toast.LENGTH_SHORT).show()
    }

    private fun generateUser(size: Int): List<messageItem> {

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
}
