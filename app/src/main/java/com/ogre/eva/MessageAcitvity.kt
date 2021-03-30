package com.ogre.eva


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MessageAcitvity: AppCompatActivity() {

    private var messadapter: RecyclerView.Adapter<messageAdapter.messageViewHolder>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mesages)
        initRecyclerView()


    }

    private fun initRecyclerView() {
        val userlist = generateUser(20)
        val messageview = findViewById<RecyclerView>(R.id.messageview)
        messageview.layoutManager = LinearLayoutManager(this)
        messageview.adapter = messageAdapter(userlist)
        messageview.setHasFixedSize(true)

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
