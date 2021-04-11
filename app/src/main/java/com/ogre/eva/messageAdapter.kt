package com.ogre.eva

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class messageAdapter(private val peoplelist: List<messageItem>, private val listener: OnItemClickListener) : RecyclerView.Adapter<messageAdapter.messageViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): messageViewHolder {
        return messageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.people_messages,parent, false))
    }


    override fun getItemCount(): Int {
        return peoplelist.size
    }
    override fun onBindViewHolder(holder: messageViewHolder, position: Int) {
        val cur = peoplelist[position]
        holder.imageview.setImageResource(cur.imageResource)
        holder.textview1.text = cur.text
        holder.textview2.text = cur.text1val


    }

    inner class messageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageview: ImageView = itemView.findViewById(R.id.person_view)
        val textview1: TextView = itemView.findViewById(R.id.person_name)
        val textview2: TextView = itemView.findViewById(R.id.person_message)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)

    }

    }
