package com.ogre.eva

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class notification : Fragment() {

    private var adapter: RecyclerView.Adapter<followAdapter.followViewHolder>? = null


    companion object{
        fun newInstance():
                notification{
            return notification()
        }

    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootview = inflater.inflate(R.layout.fragment_notification, container, false)
        val recycler = rootview.findViewById<RecyclerView>(R.id.notifline)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = followAdapter()
        recycler.setHasFixedSize(true)
        return rootview

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)




    }




    class followAdapter() :
        RecyclerView.Adapter<followAdapter.followViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): followViewHolder {
            return followViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.notificationitem, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return 100
        }

        override fun onBindViewHolder(holder: followViewHolder, position: Int) {

        }

        class followViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val imageview: ImageView = itemView.findViewById(R.id.Ppic)
            val textview1: TextView = itemView.findViewById(R.id.Username)
            val textview2: TextView = itemView.findViewById(R.id.what)
        }

    }

}
