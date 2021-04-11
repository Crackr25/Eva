package com.ogre.eva

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class searchAdapter() : RecyclerView.Adapter<searchAdapter.searchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): searchViewHolder {
        return searchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.searchitem, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: searchViewHolder, position: Int) {


    }

    class searchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageview1: ImageView = itemView.findViewById(R.id.peron1)
        val imageview2: ImageView = itemView.findViewById(R.id.peron2)
        val name1: TextView = itemView.findViewById(R.id.name1)
        val name2: TextView = itemView.findViewById(R.id.name2)
        val buton1: Button = itemView.findViewById(R.id.following)
        val buton2: Button = itemView.findViewById(R.id.button4)
        val buton3: Button = itemView.findViewById(R.id.button5)
        val buton4: Button = itemView.findViewById(R.id.button6)
    }
}

  

        
/*


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
*/


